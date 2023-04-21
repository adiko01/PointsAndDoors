package de.adiko01.PointsAndDoors;

/**
 * {@link RuntimeException} zum Versuch einen Zug zumachen, welcher nicht erlaubt ist.
 * @author adiko01
 */
@SuppressWarnings("serial")
public class IllegalMoveException extends RuntimeException {
	
	/**
	 * {@link RuntimeException} zum Versuch einen Zug zumachen, welcher nicht erlaubt ist.
	 */
	public IllegalMoveException() {
		super();
	}
	
	/**
	 * {@link RuntimeException} zum Versuch einen Zug zumachen, welcher nicht erlaubt ist.
	 * @param message Nachricht
	 */
	public IllegalMoveException(String message) {
		super(message);
	}

	/**
	 * {@link RuntimeException} zum Versuch einen Zug zumachen, welcher nicht erlaubt ist.
	 * @param cause 
	 */
	public IllegalMoveException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * {@link RuntimeException} zum Versuch einen Zug zumachen, welcher nicht erlaubt ist.
	 * @param message Nachricht
	 * @param cause
	 */
	public IllegalMoveException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * {@link RuntimeException} zum Versuch einen Zug zumachen, welcher nicht erlaubt ist.
	 * @param message Nachricht
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public IllegalMoveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
