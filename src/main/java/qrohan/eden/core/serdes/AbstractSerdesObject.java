package qrohan.eden.core.serdes;

import qrohan.eden.core.stream.AbstractObject;
import qrohan.eden.core.misc.Utils;

/**
 * Abstract class for serialization stream manipulation
 */
public abstract class AbstractSerdesObject extends AbstractObject {
    /**
     * Serialization binary data
     */
    protected String data;

    /**
     * Default constructor
     */
    public AbstractSerdesObject() {
        super();
        this.reset();
    }

    /**
     * Reset the contents of the binary data
     */
    public void reset() {
        this.data = "";
    }

    /**
     * Get the data
     * @return object data
     */
    public String getData() {
        return this.data;
    }

    /**
     * String representation of the instance
     * @return the hexadecimal string representation of the data
     */
    public String toString() {
        return Utils.binStrToHexStr(this.data);
    }

    /**
     * Get data in the form of a byte array
     * @return data byte array representation
     */
    public byte[] toByteArray() {
        return Utils.binStrToByteArray(this.data);
    }
}
