package fhb.pizza.exceptions;

public class PizzaProntoException extends Exception{
	
	/**
	 * Constructor
	 */
	public PizzaProntoException() {
		super();
	}

	/**
	 * Constructor with message
	 *
	 * @param string
	 */
	public PizzaProntoException(String string) {
		super(string);
	}

}
