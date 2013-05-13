package fhb.pizza.exceptions;

public class PizzaAktionException extends GerichtException{
	
	/**
	 * Constructor
	 */
	public PizzaAktionException() {
		super();
	}

	/**
	 * Constructor with message
	 *
	 * @param string
	 */
	public PizzaAktionException(String string) {
		super(string);
	}

}
