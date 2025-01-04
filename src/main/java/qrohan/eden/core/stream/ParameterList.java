package qrohan.eden.core.stream;

import qrohan.eden.core.serdes.Deserializator;
import qrohan.eden.core.serdes.Serializator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Abstract class representing a list of parameters
 * @param <T> type class of the parameter base element of the list
 */
public class ParameterList<T extends Parameter> extends AbstractField implements IResizable
{
	/**
	 * Parameter list size
	 */
	private long dimension;

	/**
	 * Parameter list elements
	 */
	private final ArrayList<T> params;

	/**
	 * Parameter type class
	 * <p>It is used to store the actual class of the base element of the parameter list</p>
	 */
	private final Class<T> typeParameterClass;

	/**
	 * Default constructor
	 * @param name field name
	 * @param parent parent container holding this field
	 * @param typeParameterClass type class of the base element parameter
	 */
	public ParameterList(String name, Container parent, Class<T> typeParameterClass)
	{
		super(name, parent);
		this.dimension = 0;
		this.params = new ArrayList<>();
		this.typeParameterClass = typeParameterClass;
	}

	/**
	 * Serialize object
	 * @param serial binary data used to store the serialized object
	 */
	@Override
	public final void serialize(Serializator serial)
	{
		for (T param: this.params) {
			param.serialize(serial);
		}
	}

	/**
	 * Deserialize object
	 * @param serial binary data used to extract object value
	 */
	@Override
	public final void deserialize(Deserializator serial)
	{
		for (T param: this.params) {
			param.deserialize(serial);
		}
	}

	/**
	 * Get length
	 * @return total length (in bits) of the parameter list. This is equivalent to the sum of the lengths of the elements of the list.
	 */
	@Override
	public final int getLength()
	{
		int sum = 0;
		for (T param: params) {
			sum += param.getLength();
		}
		spam("length=" + sum);
		return sum;
	}

	/**
	 * Update parameter list size
	 * <p>This method is called when the value of the reference parameter that multiplies this list is modified</p>
	 * @param newDimension new dimension
	 */
	@Override
	public final void updateDimension(long newDimension)
	{
		debug("new dimension=" + newDimension);

		if (newDimension < this.dimension) {
			// current dimension too big, trim the list
			long delta = this.dimension - newDimension;
			for (int i=0; i<delta; ++i) {
				this.params.removeLast();
			}

			// done :) update dimension
			this.dimension = newDimension;
		} else if (newDimension > this.dimension) {
			// current dimension too small, extend the list
			try {
				// create some instances 
				long delta = newDimension - this.dimension;
				Constructor<T> constructor = this.typeParameterClass.getConstructor(String.class, Container.class);
				for (int i=0; i<delta; ++i) {
					// do not register the new items into parent's children, as a list parameter
					// I manage them implicitly through my items!
					String name = typeParameterClass.getName()+"_"+(this.dimension + 1 + i);
					this.params.add(constructor.newInstance(name, null));
				}

				// done :) update dimension
				this.dimension = newDimension;
				return;
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException |
                     IllegalArgumentException | InvocationTargetException e) {
				logger.severe(e.getMessage());
			}

            // error case encountered
			System.exit(1);
		}
	}

	/**
	 * Set value at index
	 * @param index list index
	 * @param value parameter value
	 */
	public void setAt(int index, long value)
	{
		if (index < this.params.size()) {
			this.params.get(index).set(value);
		} else {
			logger.warning(String.format("Method 'setAt': index %d out of %s' dimension (=%d)", index, this.name, this.dimension));
		}
	}

	/**
	 * Get value at index
	 * @param index list index
	 * @return parameter value
	 */
	public long getAt(int index)
	{
		if (0 <= index && index < this.params.size()) {
			return this.params.get(index).get();
		} else {
			logger.warning(String.format("Method 'getAt': index %d out of %s' dimension (=%d)", index, this.name, this.dimension));
			return 0;
		}
	}
}
