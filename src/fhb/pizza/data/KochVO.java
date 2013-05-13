package fhb.pizza.data;

import java.awt.Color;
import java.util.GregorianCalendar;

public class KochVO extends AngestellterVO {

	private Color farbeSchurze;

	public Color getFarbeSchurze() {
		return farbeSchurze;
	}

	public void setFarbeSchurze(Color farbeSchurze) {
		this.farbeSchurze = farbeSchurze;
	}

	public KochVO(Color farbeSchurze, int personalNummer, float gehalt,
			int urlaubsTage, String nachname, String vorname, String strasse,
			String hausNr, String geschlecht, GregorianCalendar geburtsdatum) {
		
		super(personalNummer, gehalt, urlaubsTage, nachname, vorname, strasse,
				hausNr, geschlecht, geburtsdatum);

		this.farbeSchurze = farbeSchurze;
	}

	public boolean equals(Object o) {
		if (!(o instanceof KochVO)) {
			return false;
		} else {

			KochVO andererKoch = (KochVO) o;

			if (this.getVorName().compareToIgnoreCase(andererKoch.getVorName()) == 0
					&& (this.getNachName().compareToIgnoreCase(andererKoch
							.getNachName()) == 0)) {
				return this.farbeSchurze.equals(andererKoch.getFarbeSchurze());
			}

			return false;
		}
	}

	public String toString() {

		return "Koch: " + this.getVorName() + ", " + this.getNachName() + ", "
				+ this.getFarbeSchurze().getRGB();
	}

	@Override
	public void arbeiteInPizzeria() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void arbeite() {
		// TODO Auto-generated method stub
		
	}

}
