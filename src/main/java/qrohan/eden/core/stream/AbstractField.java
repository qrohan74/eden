package qrohan.eden.core.stream;

import qrohan.eden.core.misc.Utils;
import qrohan.eden.core.serdes.Deserializator;
import qrohan.eden.core.serdes.Serializator;

/**
 * Abstract class for all fields
 * <p>A field may be a scalar parameter, a list of parameters, a container or a list of containers</p>>
 */
public abstract class AbstractField extends AbstractNamedObject implements ISerializable {
	/**
	 * Parent container holding this field
	 */
	protected Container parent;

	/**
	 * Default contructor
	 * @param name the name of the field
	 * @param parent the parent container holding this field
	 */
	public AbstractField(String name, Container parent) {
		super(name);
		this.parent = parent;
		if (parent != null) {
			parent.addChild(this);
		}
	}

	/**
	 * Set the parent container
	 * @param parent the new parent container
	 */
	public void setParent(Container parent) {
		this.parent = parent;
	}

	/**
	 * Get the parent container
	 * @return the parent container
	 */
	public Container getParent() {
		return this.parent;
	}

	/**
	 * Get the length of the field in bits
	 * @return the field length (in bits)
	 */
	public abstract int getLength();

	/**
	 * Encode the field
	 * @return the byte array representing the field value
	 */
	public byte[] encode()
	{
		Serializator serial = new Serializator();
		serialize(serial);
		return serial.toByteArray();
	}

	/**
	 * Decode a binary data into the value of the field
	 * @param data the binary data to be decoded into the field value
	 */
	public void decode(byte[] data)
	{
		Deserializator serial = new Deserializator();
		serial.feed(data);
		deserialize(serial);
	}

	/**
	 * Get the hexadecimal representation of the encoded field
	 * @return the string representing the hexadecimal representation of the field
	 */
	public String hex()
	{
		return Utils.byteArrayToHexStr(this.encode());
	}

	/**
	 * Convert field to string. This is equivalent to the method {@link #hex()}
	 * @return the string representation of the field
	 */
	public String toString()
	{
		return hex();
	}
}
