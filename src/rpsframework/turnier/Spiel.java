package rpsframework.turnier;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Ein Spiel ist eine Begegnung zwischen zwei Spielern und läuft über eine vorgegebene Zahl von Runden. Jede Runde ist
 * ein Duell, dessen Ausgang abgefragt werden kann
 */
class Spiel {

    private SteinScherePapierSpieler spieler1;
    private SteinScherePapierSpieler spieler2;

    private int runden;

    /* Die Duelle in diesem Spiel. */
    private ArrayList<Duell> duelle;

    /* Die Punkte der beiden Spieler */
    private HashMap<SteinScherePapierSpieler, Integer> punkte;


    /**
     * Erzeugt ein neues Spiel. Das Spiel kann anschließend gestartet und nach seinem Ergebnis gefragt werden.
     * @param spieler1 Spieler 1
     * @param spieler2 Spieler 2
     * @param runden Die Anzahl der Duelle, die die beiden Spieler austragen sollen.
     */
    Spiel(SteinScherePapierSpieler spieler1, SteinScherePapierSpieler spieler2, int runden) {

        this.spieler1 = spieler1;
        this.spieler2 = spieler2;

        this.runden = runden;

        this.duelle = new ArrayList<>();
        this.punkte = new HashMap<>();

        // Die Punktzahlen der Spieler auf 0 setzen. "null" speichert die Punkte für Unentschieden.
        this.punkte.put(spieler1, 0);
        this.punkte.put(spieler2, 0);
        this.punkte.put(null, 0);
    }

    /**
     * Startet das Spiel und löst die einzelnen Begegnungen aus
     */
    void starteSpiel() {

        // Wir informieren die Spieler darüber, dass ein neues Spiel beginnt.
        spieler1.starteNeuesSpiel(this.runden);
        spieler2.starteNeuesSpiel(this.runden);

        //Für jede Runde bis zur letzten ...
        for (int i = 0; i < this.runden; i++) {

            Symbol aktuellesSymbolSpieler1 = spieler1.gibSymbol();
            Symbol aktuellesSymbolSpieler2 = spieler2.gibSymbol();

            Duell aktuellesDuell = new Duell();
            aktuellesDuell.fuegeSpielerSymbolHinzu(this.spieler1, aktuellesSymbolSpieler1);
            aktuellesDuell.fuegeSpielerSymbolHinzu(this.spieler2, aktuellesSymbolSpieler2);

            // Wir müssen den Spielern die Informationen des Duells in der aktuellen Runde mitteilen
            spieler1.nimmGegnerSymbol(aktuellesSymbolSpieler2, i + 1);
            spieler2.nimmGegnerSymbol(aktuellesSymbolSpieler1, i + 1);

            /* Wir holen uns den Gewinner des Duells und erhöhen seinen Punktestand. Sollte das Duell unentschieden sein,
               speichern wir auch diese Punkte (unter dem "Spieler" null). */
            SteinScherePapierSpieler duellGewinner = aktuellesDuell.gibGewinner();
            this.punkte.put(duellGewinner, this.punkte.get(duellGewinner) + 1);

            //TODO REMOVE
            System.out.println("Duell: " + spieler1.getName() + " (" + aktuellesDuell.gibSpielerSymbol(spieler1)
                    + ") vs. " + spieler2.getName() + " (" + aktuellesDuell.gibSpielerSymbol(spieler2) + ") -- Gewinner: "
                    + duellGewinner);
        }

        //TODO REMOVE
        System.out.println("Spiel: " + spieler1.getName() + " vs. " + spieler2.getName() + ": "
                + gibSpielerPunkte(spieler1) + ":" + gibSpielerPunkte(spieler2) + " (" + gibSpielerPunkte(null) + " Unentschieden)");
    }

    /**
     * Gibt die Punktzahl des angegebenen Spielers zurück bzw. die Anzahl von Unentschieden, falls der angegebene Spieler "null" ist.
     * @param spieler Der Spieler, dessen Punktzahl zurückgegeben werden soll.
     * @return Die aktuelle Punktzahl des Spielers.
     */
    public int gibSpielerPunkte(SteinScherePapierSpieler spieler) {

        return this.punkte.get(spieler);
    }

    @Override
    public boolean equals(Object object) {

        return object != null && this.getClass() == object.getClass() && this.punkte.equals(((Spiel) object).punkte);
    }

    @Override
    public int hashCode() {

        return Objects.hash(spieler1, spieler2, runden);
    }
}
