package qrohan.eden.core.serdes;

import qrohan.eden.core.misc.Utils;

/**
 * Class to serialize data
 */
public class Serializator extends AbstractSerdesObject {
    /**
     * Default constructor
     */
    public Serializator() {
        super();
    }

    /**
     * Serialize data
     * @param value data to serialize
     * @param nbBits number of bits to serialize from the value
     */
    public void write(long value, int nbBits) {
        if (nbBits <= 0) {
            warning("Serializator write: argument 'nbBits'="+nbBits+" negative or null. No data written.");
            return;
        }
        if (nbBits > 64) {
            warning("Serializator write: argument 'nbBits'="+nbBits+" out of range [1,64]. Use value 64 by default.");
            nbBits = 64;
        }
        this.data += Utils.longToBinStr(value, nbBits);
    }
}
