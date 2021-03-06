package rpsframework.beispiele;

import rpsframework.basis.SteinScherePapierSpieler;
import rpsframework.basis.Symbol;

/**
 * Ein einfacher Beispielgegner, der immer Stein spielt
 */
public class SpielerStein extends SteinScherePapierSpieler {

    public SpielerStein(int spielernummer) {

        super(spielernummer);
    }

    /**
     * Gibt immer das Symbol Stein zurück.
     *
     * @return Symbol Stein
     */
    @Override
    public Symbol gibSymbol() {

        // Spielt immer Stein
        return Symbol.STEIN;
    }
}
