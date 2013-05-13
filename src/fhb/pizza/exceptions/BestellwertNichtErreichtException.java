package fhb.pizza.exceptions;

public class BestellwertNichtErreichtException extends BestellException{
	
	/**
	 * Constructor
	 */
	public BestellwertNichtErreichtException() {
		super();
	}

	/**
	 * Constructor with message
	 *
	 * @param string
	 */
	public BestellwertNichtErreichtException(String string) {
		super(string);
	}

}
