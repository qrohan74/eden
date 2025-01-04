package qrohan.eden.core.stream;

import qrohan.eden.core.serdes.Deserializator;
import qrohan.eden.core.serdes.Serializator;

import java.util.ArrayList;

/**
 * Abstract class representing a scalar container
 */
public class Container extends AbstractField {
	// --- BEGIN FIELDS ---

	/**
	 * List of the fields contained by this container</p>
	 */
	ArrayList<AbstractField> fields;

	// --- END FIELDS ---

	// --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

	/**
	 * Default constructor
	 * @param name field name
	 * @param parent parent container holding this field
	 */
	public Container(String name, Container parent) {
		super(name, parent);
		fields = new ArrayList<>();
	}

	// --- END CONSTRUCTORS/DESTRUCTORS ---

	// --- BEGIN PUBLIC METHODS ---

	/**
	 * Serialize object
	 * @param serial binary data used to store the serialized object
	 */
	@Override
	public final void serialize(Serializator serial) {
		for (AbstractField field: fields) {
			field.serialize(serial);
		}
	}

	/**
	 * Deserialize object
	 * @param serial binary data used to extract object value
	 */
	@Override
	public final void deserialize(Deserializator serial) {
		for (AbstractField field: fields) {
			field.deserialize(serial);
		}
	}

	/**
	 * Get length
	 * @return total length (in bits) of the container. This is equivalent to the sum of the lengths of the fields in the container.
	 */
	@Override
	public final int getLength() {
		int sum = 0;
		for (AbstractField field: fields) {
			sum += field.getLength();
		}
		spam("length=" + sum);
		return sum;
	}

	/**
	 * Append a new field to the container
	 * @param item new element
	 */
	public void addChild(AbstractField item) {
		fields.add(item);
	}

	// --- END PUBLIC METHODS ---
} // END OF CLASS
