package controller;
import java.util.logging.Logger;
import controller.MapJsonParser;

public class InvalidMapException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(MapJsonParser.class.getName());

	/**
	 * This method is used print InvalidMapException message.
	 * @param message contains exception message.
	 */
	public InvalidMapException(String message) {
		LOGGER.warning(message);
	}
	
	
}
