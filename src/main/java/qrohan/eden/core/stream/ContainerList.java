package qrohan.eden.core.stream;

import qrohan.eden.core.serdes.Deserializator;
import qrohan.eden.core.serdes.Serializator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Abstract class representing a list of containers
 * @param <T> type class of the container base element of the list
 */
public class ContainerList<T extends Container> extends AbstractField implements IResizable
{
	/**
	 * Container list size
	 */
	private long dimension;

	/**
	 * Container list elements
	 */
	private final ArrayList<T> containers;

	/**
	 * Container type class
	 * <p>It is used to store the actual class of the base element of the container list</p>
	 */
	private final Class<T> typeContainerClass;

	/**
	 * Default constructor
	 * @param name field name
	 * @param parent parent container holding this field
	 * @param typeContainerClass type class of the base element container
	 */
	public ContainerList(String name, Container parent, Class<T> typeContainerClass)
	{
		super(name, parent);
		this.dimension = 0;
		this.containers = new ArrayList<>();
		this.typeContainerClass = typeContainerClass;
	}

	/**
	 * Serialize object
	 * @param serial binary data used to store the serialized object
	 */
	@Override
	public final void serialize(Serializator serial)
	{
		for (T container: this.containers) {
			container.serialize(serial);
		}
	}

	/**
	 * Deserialize object
	 * @param serial binary data used to extract object value
	 */
	@Override
	public final void deserialize(Deserializator serial)
	{
		for (T container: this.containers) {
			container.deserialize(serial);
		}
	}

	/**
	 * Get length
	 * @return total length (in bits) of the container list. This is equivalent to the sum of the lengths of the elements of the list.
	 */
	@Override
	public final int getLength()
	{
		int sum = 0;
		for (T container: containers) {
			sum += container.getLength();
		}
		spam("length=" + sum);
		return sum;
	}

	/**
	 * Update container list size
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
				this.containers.removeLast();
			}

			// done :) update dimension
			this.dimension = newDimension;
		} else if (newDimension > this.dimension) {
			// current dimension too small, extend the list
			try {
				// create some instances 
				long delta = newDimension - this.dimension;
				Constructor<T> constructor = this.typeContainerClass.getConstructor(String.class, Container.class);
				for (int i=0; i<delta; ++i) {
					// do not register the new items into parent's children because I am the child
					// and I manage them implicitly through my list!
					String name = typeContainerClass.getName()+"_"+(this.dimension + 1 + i);
					this.containers.add(constructor.newInstance(name, null));
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
	 * Get container at index
	 * @param index list index
	 * @return container
	 */
	public T getAt(int index)
	{
		if (0 <= index && index < this.containers.size()) {
			return this.containers.get(index);
		} else {
			logger.warning(String.format("Method 'getAt': index %d out of %s' dimension (=%d)", index, this.name, this.dimension));
			return null;
		}
	}
}
