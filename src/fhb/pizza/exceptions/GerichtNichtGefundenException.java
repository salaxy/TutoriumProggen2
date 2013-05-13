package fhb.pizza.exceptions;

public class GerichtNichtGefundenException extends GerichtException{
	
	/**
	 * Constructor
	 */
	public GerichtNichtGefundenException() {
		super();
	}

	/**
	 * Constructor with message
	 *
	 * @param string
	 */
	public GerichtNichtGefundenException(String string) {
		super(string);
	}

}
