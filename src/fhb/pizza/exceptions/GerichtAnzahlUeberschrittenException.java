package fhb.pizza.exceptions;

public class GerichtAnzahlUeberschrittenException extends BestellException{
	
	/**
	 * Constructor
	 */
	public GerichtAnzahlUeberschrittenException() {
		super();
	}

	/**
	 * Constructor with message
	 *
	 * @param string
	 */
	public GerichtAnzahlUeberschrittenException(String string) {
		super(string);
	}

}
