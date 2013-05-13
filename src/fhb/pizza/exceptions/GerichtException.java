package fhb.pizza.exceptions;

public class GerichtException extends PizzaProntoException{
	
	/**
	 * Constructor
	 */
	public GerichtException() {
		super();
	}

	/**
	 * Constructor with message
	 *
	 * @param string
	 */
	public GerichtException(String string) {
		super(string);
	}

}
