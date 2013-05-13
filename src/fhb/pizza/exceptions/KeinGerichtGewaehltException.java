package fhb.pizza.exceptions;

public class KeinGerichtGewaehltException extends BestellException{
	
	/**
	 * Constructor
	 */
	public KeinGerichtGewaehltException() {
		super();
	}

	/**
	 * Constructor with message
	 *
	 * @param string
	 */
	public KeinGerichtGewaehltException(String string) {
		super(string);
	}

}
