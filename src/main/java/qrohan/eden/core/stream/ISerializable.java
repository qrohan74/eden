package qrohan.eden.core.stream;

import qrohan.eden.core.serdes.Deserializator;
import qrohan.eden.core.serdes.Serializator;

/**
 * Interface for serializable objects
 */
public interface ISerializable {
	/**
	 * Serialize object
	 * @param serial binary data used to store the serialized object
	 */
	void serialize(Serializator serial);

	/**
	 * Deserialize object
	 * @param serial binary data used to extract object value
	 */
	void deserialize(Deserializator serial);
}
