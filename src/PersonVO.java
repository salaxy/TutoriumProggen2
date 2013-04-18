import java.util.GregorianCalendar;

public class PersonVO {

	protected String nachName;
	protected String vorName;
	protected String strasse;
	protected String hausNr;
	protected String geschlecht;
	protected GregorianCalendar geburtsdatum;

	
	public PersonVO(String nachName, String vorName, String strasse,
			String hausNr, String geschlecht, GregorianCalendar geburtsdatum) {
		super();
		this.nachName = nachName;
		this.vorName = vorName;
		this.strasse = strasse;
		this.hausNr = hausNr;
		this.geschlecht = geschlecht;
		this.geburtsdatum = geburtsdatum;
	}
	
	
	public PersonVO(String nachName, String vorName) {
		this(nachName, vorName, "empty Street", "leere Hausnummer","unisex", new GregorianCalendar());
	}
	
	public PersonVO(String nachName) {
		this(nachName, "kein Vorname", "empty Street", "leere Hausnummer","unisex", new GregorianCalendar());
	}
	
	public PersonVO() {
		this("Mustermann", "Max", "empty Street", "leere Hausnummer","unisex", new GregorianCalendar());
	}
	
	
	public String getNachName() {
		return nachName;
	}

	public void setNachName(String nachName) {
		this.nachName = nachName;
	}

	public String getVorName() {
		return vorName;
	}

	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausNr() {
		return hausNr;
	}

	public void setHausNr(String hausNr) {
		this.hausNr = hausNr;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	public GregorianCalendar getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(GregorianCalendar geburtsdatum) {
		if (berechnerAlter(geburtsdatum) >= 18)
			this.geburtsdatum = geburtsdatum;

	}
	public boolean equals(Object o) {
		if (!(o instanceof PersonVO)) {
			return false;
		} else {
			return this.getVorName().equals(((PersonVO)o).getVorName())
				 && this.getNachName().equals(((PersonVO)o).getNachName())
				 && this.getGeschlecht().equals(((PersonVO)o).getGeschlecht())
				 && this.getStrasse().equals(((PersonVO)o).getStrasse())
				 && this.getHausNr().equals(((PersonVO)o).getHausNr())
				 && this.getGeburtsdatum().equals(((PersonVO)o).getGeburtsdatum());
		}
	}


	public String toString() {
		return "Name: " + this.getVorName() + " " + this.getNachName() + "\n "
				+ "Straﬂe: " + this.getStrasse() +" "+ this.getHausNr() +"\n "
				+ "Geschlecht: " + this.getGeschlecht() + "\n "
				+ "Geboren: " + this.getGeburtsdatumStr() + "\n "
				+ "Alter: " + this.berechnerAlter(this.getGeburtsdatum()) + "\n ";
	}

	private String getGeburtsdatumStr(){
		return 	this.getGeburtsdatum().get(GregorianCalendar.DAY_OF_MONTH)
				+ "."
				+ (this.getGeburtsdatum().get(GregorianCalendar.MONTH) + 1)
				+ "." + this.getGeburtsdatum().get(GregorianCalendar.YEAR);
	}
	
	

	
	public short berechnerAlter(GregorianCalendar geburtsdatum) {
		GregorianCalendar heute = new GregorianCalendar();

		int dayDiff = heute.get(GregorianCalendar.DAY_OF_MONTH)
				- geburtsdatum.get(GregorianCalendar.DAY_OF_MONTH);
		int monthDiff = heute.get(GregorianCalendar.MONTH)+1
				- geburtsdatum.get(GregorianCalendar.MONTH);
		int yearDiff = heute.get(GregorianCalendar.YEAR)
				- geburtsdatum.get(GregorianCalendar.YEAR);

		if (monthDiff < 0) {
			return (short) (yearDiff-1);
		} else {
			if (monthDiff > 0) {
				return (short) yearDiff;
			} else {
				if (dayDiff >= 0) {
					return (short) (yearDiff);
				} else {
					return (short) (yearDiff-1);
				}
			}
		}
	}
}
