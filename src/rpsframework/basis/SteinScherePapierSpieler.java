package rpsframework.basis;

/**
 * Die Vorgabe für einen SteinScherePapierSpieler.
 *
 * Ein Spieler kann jederzeit innerhalb einer Spielrunde nach einem Symbol gefragt werden und muss dieses dann zurückgeben.
 * Ein Spieler sollte sich die aktuelle Spielrunde merken, um seine Taktik während des Spiels gegen einen Gegner anzupassen.
 *
 */
public abstract class SteinScherePapierSpieler {

    private final int spielernummer;

    protected SteinScherePapierSpieler(int spielernummer) {

        this.spielernummer = spielernummer;
    }

    /**
     * Fragt den Spieler nach dem nächsten Symbol, welches er spielen möchte. Diese Methode muss überschrieben werden.
     * @return Das nächste Symbol
     */
    public abstract Symbol gibSymbol();

    /**
     * Teil dem Spieler mit, dass ein neues Spiel gegen einen neuen Gegner beginnt. Es ist ratsam, alle Informationen für
     * das vorherige Spiel zu verwerfen, da nicht garantiert wird, dass man direkt wieder gegen denselben Spieler spielt.
     * @param runden Die Anzahl der Runden für das neue Spiel
     */
    public void starteNeuesSpiel(int runden) {

        // Optional: Implementierung erfolgt in Unterklasse
    }

    /**
     * Teilt dem Spieler das Symbol mit, welches der Gegner in der angegebenen Runde gespielt hat.
     * @param symbol Das vom Gegner gespielte Symbol in der angegebenen Runde
     * @param runde Die Spielrunde
     */
    public void nimmGegnerSymbol(Symbol symbol, int runde) {

        // Optional: Implementierung erfolgt in Unterklasse
    }

    /**
     * Gibt den Namen des Spielers zurück.
     * @return Der Name des Spielers als String
     */
    public final String getName() {

        return "Spieler " + spielernummer + " (" + this.getClass().getSimpleName() + ")";
    }

    /**
     * Gibt die Spielernummer des Spielers zurück
     * @return Die Spielernummer
     */
    public final int getSpielernummer() {

        return this.spielernummer;
    }

    /**
     * Gibt zurück, ob das übergebene Objekt gleich diesem Objekt ist. Der Test auf Gleichheit ist in Java sehr wichtig
     * und wird an vielen verschiedenen Stellen benutzt. Die Gleichheit zweier Objekte hängt in der Regel von Eigenschaften
     * des Objekts ab.
     * @param obj Das zu vergleichende Objekt
     * @return Wahr, wenn beide Objekte gleich sind, sonst falsch.
     */
    @Override
    public final boolean equals(Object obj) {

        // Test auf Null, Klassengleichheit und Hashcode sind Standard, falls auch der Name übereinstimmt, sind beide gleich.
        return (obj != null && obj.getClass() == this.getClass() && this.hashCode() == obj.hashCode()
                && this.getName().equals(((SteinScherePapierSpieler)obj).getName()));
    }

    /**
     * Gibt den Hashcode dieses Objekts zurück. Wird für den Test auf Gleichheit benötigt.
     * @return Der Hashcode dieses Objekts
     */
    @Override
    public final int hashCode() {

        // Wir berechnen den Hashcode auf dem Namen des Spielers.
        return this.getName().hashCode();
    }
}
