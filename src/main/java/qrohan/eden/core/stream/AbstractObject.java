package qrohan.eden.core.stream;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstract class for all objects
 */
public abstract class AbstractObject {
	/**
	 * Reference to the default logger
	 */
	protected Logger logger = Logger.getLogger("default");

	/**
	 * Default constructor
	 */
	public AbstractObject() {
	}

	/**
	 * Logging method to print an information message
	 * @param message information message
	 */
	protected void info(String message) {
		logger.log(Level.INFO, getClass().getName()+" - "+message);
	}

	/**
	 * Logging method to print a warning message
	 * @param message warning message
	 */
	protected void warning(String message) {
		logger.log(Level.WARNING, getClass().getName()+" - "+message);
	}

	/**
	 * Logging method to print an error message
	 * @param message error message
	 */
	protected void error(String message) {
		logger.log(Level.SEVERE, getClass().getName()+" - "+message);
	}

	/**
	 * Logging method to print a debug message
	 * @param message debug message
	 */
	protected void debug(String message) {
		logger.log(Level.FINER, getClass().getName()+" - "+message);
	}

	/**
	 * Logging method to print a spam message
	 * @param message spam message
	 */
	protected void spam(String message) {
		logger.log(Level.FINEST, getClass().getName()+" - "+message);
	}

	/**
	 * Set the logging level of the default logger
	 * @param newLevel new logging level
	 */
	public void setLoggingLevel(Level newLevel) {
		logger.setLevel(newLevel);
	}
}
