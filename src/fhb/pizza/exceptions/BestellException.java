package fhb.pizza.exceptions;

public class BestellException extends Exception{
	
	/**
	 * Constructor
	 */
	public BestellException() {
		super();
	}

	/**
	 * Constructor with message
	 *
	 * @param string
	 */
	public BestellException(String string) {
		super(string);
	}

}
