import java.util.GregorianCalendar;

public class KundeVO {

	private final int ID;
	private String nachname;
	private String vorname;
	private String geschlecht;
	private GregorianCalendar geburtsdatum;

	private static int naechstID = 0;

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
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

	public static short berechnerAlter(GregorianCalendar geburtsdatum) {
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

	public KundeVO() {
		this("Mustermann", "Max", "m", new GregorianCalendar(1990, 1, 1));
	}

	public KundeVO(String nachname, String vorname) {
		this(vorname, nachname, "unisex", new GregorianCalendar(1990, 1, 1));
	}

	public KundeVO(String nachname, String vorname, String geschlecht) {
		this(vorname, nachname, geschlecht, new GregorianCalendar(1990, 1, 1));
	}

	public KundeVO(String nachname, String vorname, String geschlecht,
			GregorianCalendar geburtsdatum) {
		super();
		this.ID = naechstID;
		this.nachname = nachname;
		this.vorname = vorname;
		this.geschlecht = geschlecht;
		this.geburtsdatum = geburtsdatum;

		naechstID++;
	}

	public boolean equals(Object o) {
		if (!(o instanceof KundeVO)) {
			return false;
		} else {
			return this.ID == ((KundeVO) o).getID();
		}
	}

	public int getID() {
		return ID;
	}

	public String toString() {
		return "Kunde: " + this.vorname + ", " + this.nachname + ", "
				+ this.geschlecht + ", " + this.ID + ", "
				+ getGeburtsdatumStr()
				+ ", Alter: " + berechnerAlter(geburtsdatum);
	}
	
	
	private String getGeburtsdatumStr(){
		return 	this.getGeburtsdatum().get(GregorianCalendar.DAY_OF_MONTH)
				+ "."
				+ (this.getGeburtsdatum().get(GregorianCalendar.MONTH) + 1)
				+ "." + this.getGeburtsdatum().get(GregorianCalendar.YEAR);
	}
}
