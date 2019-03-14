package impl;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

import java.util.Scanner;

/**
 * Ein Spieler kann...
 * <p>
 * ... an einem Spiel gegen einen anderen Spieler teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Spieler ein Spiel bestreiten
 * <p>
 * Dieser Spieler repräsentiert einen manuellen Spieler, welcher über die Kommandozeile
 * interaktiv gesteuert werden kann.
 */
public class ManuellerSpieler implements SteinScherePapierSpieler {

    /**
     * Gibt den Namen dieses Spielers zurück
     *
     * @return Name des Spielers
     */
    @Override
    public String getName() {
        return "Du";
    }

    /**
     * Gibt das Symbol des Spielers zurück. Fragt interaktiv beim Benutzer
     * nach einer Eingabe und gibt diese zurück.
     *
     * @return Getroffene Auswahl des Symbols
     */
    @Override
    public Symbol gibSymbol() {
        System.out.println("Welches Symbol möchtest du spielen?");
        System.out.println("[1] Stein");
        System.out.println("[2] Schere");
        System.out.println("[3] Papier");

        // Eingabe vom Benutzer anfordern
        Scanner sc = new Scanner(System.in);
        int eingabe = sc.nextInt();

        // Prüfe die Eingabe und übersetze sie in die Auswahl eines Symbols.
        // Ist die Eingabe nicht gültig nehme Stein.
        Symbol auswahl;
        switch (eingabe) {
            case 1:
                auswahl = Symbol.STEIN;
                break;
            case 2:
                auswahl = Symbol.SCHERE;
                break;
            case 3:
                auswahl = Symbol.PAPIER;
                break;
            default:
                auswahl = Symbol.STEIN;
                break;
        }

        return auswahl;
    }

    /**
     * Bereite ein neues Spiel vor. Keine Initialisierung notwendig
     * da interaktiv.
     *
     * @param runden Die Anzahl der Runden für das neue Spiel
     */
    @Override
    public void starteNeuesSpiel(int runden) {
        System.out.println("Ein neue Spiel beginnt!");
    }

    @Override
    public void nimmGegnerSymbol(Symbol symbol, int runde) {

        //wird nicht verwendet
    }
}
