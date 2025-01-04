package qrohan.eden.core.misc;

/**
 * Class providing some common methods for data manipulation
 */
public class Utils {
    /**
     * Default constructor
     */
    public Utils() {
        // empty
    }

    /**
     * Convert a byte array to a binary string
     * <p>The result is expressed in big endian</p>
     * @param bytes data byte array
     * @return the binary string representation
     */
    public static String byteArrayToBinStr(byte[] bytes) {
        StringBuilder binStr = new StringBuilder();
        for (byte b: bytes) {
            String tmp = "00000000"+Integer.toBinaryString(b);
            int n = tmp.length();
            binStr.append(tmp, n - 8, n);
        }
        return binStr.toString();
    }

    /**
     * Convert a byte array to a hexadecimal string
     * <p>The result is expressed in big endian, and each hexadecimal byte is separated with a space</p>
     * @param data data byte array
     * @return the hexadecimal string representation
     */
    public static String byteArrayToHexStr(byte[] data) {
        if (data.length == 0) {
            return "";
        } else {
            StringBuilder str = new StringBuilder();
            for (byte b: data)
                str.append(String.format("%02X ", b));
            return str.substring(0, str.length() - 1); // remove trailing space
        }
    }

    /**
     * Convert a binary string to a byte array
     * <p>The string is left-padded with zeros if the number of bits is not aligned on byte size (i.e. 8)</p>
     * @param binStr binary string (e.g. "00011110101110")
     * @return the byte array representation (in big endian)
     */
    public static byte[] binStrToByteArray(String binStr) {
        // padding with leading '0' bits (in order to align on byte size)
        int n = binStr.length() % 8;
        if (n != 0)
            n = 8-n;
        String bitString = "0".repeat(n) + binStr;

        // convert to byte array
        byte[] byteArray = new byte[bitString.length()/8];
        for(int i = 0; i < byteArray.length; i++) {
            byteArray[i] = (byte)Integer.parseInt(bitString.substring(i * 8, i * 8 + 8), 2);
        }
        return  byteArray;
    }

    /**
     * Convert a binary string to a hexadecimal string
     * <p>The string is left-padded with zeros if the number of bits is not aligned on byte size (i.e. 8)</p>
     * <p>Each hexadecimal byte is separated with a space</p>
     * @param binStr binary string
     * @return the hexadecimal representation
     */
    public static String binStrToHexStr(String binStr) {
        StringBuilder str = new StringBuilder();
        byte[] byteArray = binStrToByteArray(binStr);
        if (byteArray.length == 0) {
            return "";
        } else {
            for (byte b: byteArray)
                str.append(String.format("%02X ", b));
            return str.substring(0, str.length() - 1); // remove trailing space;
        }
    }

    /**
     * Convert a long integer to a binary string
     * <p>The result string is encoded on 64 bits (i.e. long size)</p>
     * @param value long value
     * @return the binary string representation
     */
    public static String longToBinStr(long value) {
        return longToBinStr(value, 64);
    }

    /**
     * Convert a long integer to a binary string
     * @param value long value
     * @param nbBits the number of bits to use to encode the result string
     * @return the binary string representation
     */
    public static String longToBinStr(long value, int nbBits) {
        String str = "0".repeat(64)+Long.toBinaryString(value);
        return str.substring(str.length() - nbBits);
    }


    /**
     * Convert an integer to a binary string
     * <p>The result string is encoded on 32 bits (i.e. integer size)</p>
     * @param value integer value
     * @return the binary string representation
     */
    public static String intToBinStr(int value) {
        return intToBinStr(value, 32);
    }

    /**
     * Convert an integer to a binary string
     * @param value integer value
     * @param nbBits the number of bits to use to encode the result string
     * @return the binary string representation
     */
    public static String intToBinStr(int value, int nbBits) {
        String str = "0".repeat(32)+Integer.toBinaryString(value);
        return str.substring(str.length() - nbBits);
    }
}
