package fhb.pizza.data;
import java.util.GregorianCalendar;


public abstract class AngestellterVO extends PersonVO {

	protected int personalNummer;
	protected float gehalt;
	protected int urlaubsTage;

	public int getPersonalNummer() {
		return personalNummer;
	}

	public void setPersonalNummer(int personalNummer) {
		this.personalNummer = personalNummer;
	}

	public float getGehalt() {
		return gehalt;
	}

	public void setGehalt(float gehalt) {
		this.gehalt = gehalt;
	}

	public int getUrlaubsTage() {
		return urlaubsTage;
	}

	public void setUrlaubsTage(int urlaubsTage) {
		this.urlaubsTage = urlaubsTage;
	}

	public AngestellterVO(int personalNummer, float gehalt, int urlaubsTage,
			String nachName, String vorName, String strasse, String hausNr,
			String geschlecht, GregorianCalendar geburtsdatum) {
		super(nachName, vorName, strasse, hausNr, geschlecht, geburtsdatum);
		this.personalNummer = personalNummer;
		this.gehalt = gehalt;
		this.urlaubsTage = urlaubsTage;
	}

	protected abstract void arbeiteInPizzeria();

	protected abstract void arbeite();

}
