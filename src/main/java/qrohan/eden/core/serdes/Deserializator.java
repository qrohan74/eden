package qrohan.eden.core.serdes;

import qrohan.eden.core.misc.Utils;

/**
 * Class to deserialize binary data
 */
public class Deserializator extends AbstractSerdesObject {
    /**
     * Default contructor
     */
    public Deserializator() {
        super();
    }

    /**
     * Deserialize data
     * @param nbBits number of bits to deserialize
     * @return deserialized value
     */
    public long read(int nbBits) {
        // check number of bits
        if (nbBits <= 0) {
            warning("Deserializator read: argument 'nbBits'="+nbBits+" negative or null. No data read.");
            return 0;
        }
        int n = this.data.length();
        if (n == 0) {
            warning("Deserializator read: empty data.");
            return 0;
        } else if (n <= 64 && nbBits > n) {
            warning("Deserializator read: argument 'nbBits'="+nbBits+" out of data range [1,"+n+"]. Use value "+n+" by default.");
            nbBits = n;
        } else if (nbBits > 64) {
           warning("Deserializator read: argument 'nbBits'="+nbBits+" out of range [1,64]. Use value 64 by default.");
            nbBits = 64;
        }
        String value = this.data.substring(0,nbBits);
        this.data = this.data.substring(nbBits);
        return Long.parseLong(value,2);
    }

    /**
     * Feed the instance with new data
     * @param bytes byte array of data
     */
    public void feed(byte[] bytes) {
        this.data += Utils.byteArrayToBinStr(bytes);
    }

    /**
     * Feed the instance with new data
     * @param str string representation of the new data
     * @param base numerical base of the string (binary=2, 8=octal or 16=hexadecimal)
     */
    public void feed(String str, int base) {
        int nbBits = base == 2 ? 1 : (base == 8 ? 3 : (base == 16 ? 4 : -1));
        if (nbBits == -1) {
            warning("Deserializator feed: invalid unsupported base "+base+". Expected binary (2), octal (8) or hex (16)");
            return;
        }

        // feed data, character by character
        StringBuilder binStr = new StringBuilder();
        for (char c: str.toCharArray()) {
            // convert character to integer
            int i = Character.digit(c, base);
            if (i == -1) {
                warning("Deserializator feed: invalid base "+base+" string "+str);
                return;
            }

            // compute data in binary format
            binStr.append(Utils.intToBinStr(i, nbBits));
        }

        // feed
        this.data += binStr;
    }
}
