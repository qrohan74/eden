package qrohan.eden.core.stream;

import qrohan.eden.core.serdes.Deserializator;
import qrohan.eden.core.serdes.Serializator;

/**
 * Abstract class representing a scalar parameter
 */
public abstract class Parameter extends AbstractField
{
	// --- BEGIN FIELDS ---

	/**
	 * Parameter value
	 */
	private long value;

	/**
	 * Parameter factor
	 * <p>If this instance does not multiply any parameter list or container list, this attribute should be null</p>
	 */
	private IResizable factor;

	// --- END FIELDS ---

	// --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

	/**
	 * Default constructor
	 * @param name field name
	 * @param parent parent container holding this field
	 */
	public Parameter(String name, Container parent)
	{
		super(name, parent);
		this.value = 0L;
	}

	// --- END CONSTRUCTORS/DESTRUCTORS ---

	// --- BEGIN PUBLIC METHODS ---

	/**
	 * Serialize object
	 * @param serial binary data used to store the serialized object
	 */
	@Override
	public final void serialize(Serializator serial) {
		serial.write(this.value, this.getLength());
	}

	/**
	 * Deserialize object
	 * @param serial binary data used to extract object value
	 */
	@Override
	public final void deserialize(Deserializator serial) {
		int n = this.getLength();
		long mask = (1L << n) - 1; // n bits mask
		this.set(serial.read(n) & mask); // the mask is a bit paranoid... maybe we could just be removed it
	}

	/**
	 * Set factor object
	 * @param factor object that this instance multiplies
	 */
	public void setFactor(IResizable factor) {
		this.factor = factor;
	}

	/**
	 * Set parameter value
	 * @param value new value
	 */
	public void set(long value) {
		this.value = value;

		// notify the eventual field I multiply
		if (this.factor != null) {
			this.factor.updateDimension(value);
		}
	}

	/**
	 * Get parameter value
	 * @return parameter value
	 */
	public long get() {
		return this.value;
	}

	// --- END PUBLIC METHODS ---
} // END OF CLASS Parameter
