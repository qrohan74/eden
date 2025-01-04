package qrohan.eden.core.stream;

import qrohan.eden.core.serdes.Deserializator;
import qrohan.eden.core.serdes.Serializator;

/**
 * Abstract class representing a buffer
 */
public abstract class Buffer extends AbstractField
{
	// --- BEGIN FIELDS ---

	/**
	 * Buffer data
	 */
	private byte[] data;

	/**
	 * Buffer length
	 */
	private int length;

	// --- END FIELDS ---

	// --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

	/**
	 * Default constructor
	 * @param name field name
	 * @param parent parent container holding this field
	 */
	public Buffer(String name, Container parent)
	{
		super(name, parent);
		this.data = new byte[length];
	}

	// --- END CONSTRUCTORS/DESTRUCTORS ---

	// --- BEGIN PUBLIC METHODS ---

	/**
	 * Serialize object
	 * @param serial binary data used to store the serialized object
	 */
	@Override
	public final void serialize(Serializator serial) {
		for (int i=0; i<this.length; ++i) {
			serial.write(this.data[i], 8);
		}
	}

	/**
	 * Deserialize object
	 * @param serial binary data used to extract object value
	 */
	@Override
	public final void deserialize(Deserializator serial) {
		for (int i=0; i<this.length; ++i) {
			this.data[i] = (byte)(serial.read(8) & 0xFF);
		}
	}

	/**
	 * Get length
	 * @return total length (in bits) of the buffer
	 */
	@Override
	public final int getLength() {
		return 8 * this.length; // in bits
	}

	/**
	 * Set or update buffer length
	 * @param newLength new data length (in octets)
	 */
	public void setLength(int newLength) {
		if (newLength < 0) {
			warning("Method 'setLength': negative length");
			return;
		}

		// temporary copy
		byte[] tmp = new byte[this.length];
		System.arraycopy(this.data, 0, tmp, 0, this.length);

		// the method should not touch the actual data
		this.data = new byte[newLength];
		System.arraycopy(tmp, 0, this.data, 0, Math.min(newLength, this.length));

		// update length
		this.length = newLength;
	}

	/**
	 * Set buffer data
	 * @param newData new data
	 */
	public void set(byte[] newData) {
		if (newData.length != this.length) {
			warning(String.format("Method 'set': new buffer size = %d different from buffer size = %d", newData.length, this.length));
			return;
		}
        System.arraycopy(newData, 0, this.data, 0, this.length);
	}

	/**
	 * Get buffer data
	 * @return buffer data
	 */
	public byte[] get() {
		return this.data;
	}

	/**
	 * Set value at index
	 * @param index list index
	 * @param value new data value
	 */
	public void setAt(int index, byte value)
	{
		if (index > 0 && index < this.length) {
			this.data[index] = value;
		} else {
			warning(String.format("Method 'setAt': index %d out of %s' dimension (=%d)", index, this.name, this.length));
		}
	}

	/**
	 * Get value at index
	 * @param index list index
	 * @return data value
	 */
	public long getAt(int index)
	{
		if (0 <= index && index < this.length) {
			return this.data[index] & 0xFF;
		} else {
			warning(String.format("Method 'getAt': index %d out of %s' dimension (=%d)", index, this.name, this.length));
			return 0;
		}
	}

	// --- END PUBLIC METHODS ---
} // END OF CLASS Buffer
