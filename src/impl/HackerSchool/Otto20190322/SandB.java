package impl.HackerSchool.Otto20190322;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein Spieler kann...
 *
 * ... an einem Spiel gegen einen anderen Spieler teilnehmen
 * ....an einem Turnier teilnehmen und dabei gegen mehrere Spieler ein Spiel bestreiten
 */
public class SandB extends SteinScherePapierSpieler {
    int zahl=0;


    /**
     * Erzeugt ein neues Objekt dieser Klasse.
     * @param spielernummer Die Spielernummer des Spielers in einem Spiel bzw. Turnier. Die Spielernummer muss für jeden
     *                      Spieler verschieden sein.
     */
    public SandB(int spielernummer) {

        super(spielernummer);
    };

    @Override
    public Symbol gibSymbol() {
        zahl=zahl+1;

        if (zahl>6){
            zahl=0;
        }

        if(zahl  == 5) {
            return Symbol.SCHERE;
        } else if (zahl == 1) {
            return Symbol.PAPIER;
        }  else if (zahl == 2) {
            return Symbol.STEIN;
        } else if (zahl==3 ) {
            return Symbol.PAPIER;
        }else if (zahl==4) {
            return Symbol.SCHERE;
        } else if (zahl==6){
            return Symbol.STEIN;





        } else {
            return Symbol.SCHERE;


        }


    }

    // Füge hier drunter die fehlende Methode ein
}
