package qrohan.eden.core.stream;

import java.util.logging.Level;

/**
 * Abstract class for all named objects
 */
public abstract class AbstractNamedObject extends AbstractObject {
	/**
	 * Name of the object
	 */
	protected String name;

	/**
	 * Default constructor
	 * @param name Name of the instance
	 */
	public AbstractNamedObject(String name) {
		this.name = name;
	}

	/**
	 * Get the name of the instance
	 * @return the name of the instance
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Logging method to print an information message
	 * @param message information message
	 */
	protected void info(String message) {
		logger.log(Level.INFO, this.name+" - "+message);
	}

	/**
	 * Logging method to print a warning message
	 * @param message warning message
	 */
	protected void warning(String message) {
		logger.log(Level.WARNING, this.name+" - "+message);
	}

	/**
	 * Logging method to print an error message
	 * @param message error message
	 */
	protected void error(String message) {
		logger.log(Level.SEVERE, this.name+" - "+message);
	}

	/**
	 * Logging method to print a debug message
	 * @param message debug message
	 */
	protected void debug(String message) {
		logger.log(Level.FINE, this.name+" - "+message);
	}

	/**
	 * Logging method to print a spam message
	 * @param message spam message
	 */
	protected void spam(String message) {
		logger.log(Level.FINER, this.name+" - "+message);
	}
}
