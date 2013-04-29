import java.util.GregorianCalendar;

public class KundeVO extends PersonVO {

	private final int ID;
	private static int naechstID = 0;

	private Bestellung bestellung;

	public KundeVO() {
		this("Mustermann", "Max", "m", new GregorianCalendar(1990, 1, 1),
				"Vereinsstr.", "20");
	}

	public KundeVO(String nachname, String vorname) {
		this(vorname, nachname, "unisex", new GregorianCalendar(1990, 1, 1),
				"Vereinsstr.", "20");
	}

	public Bestellung getBestellung() {
		return bestellung;
	}

	public void setBestellung(Bestellung bestellung) {
		this.bestellung = bestellung;
	}

	public KundeVO(String nachname, String vorname, String geschlecht) {
		this(vorname, nachname, geschlecht, new GregorianCalendar(1990, 1, 1),
				"Vereinsstr.", "20");
	}

	public KundeVO(String nachname, String vorname, String geschlecht,
			GregorianCalendar geburtsdatum, String strasse, String hausNr) {
		super(nachname, vorname, strasse, hausNr, geschlecht, geburtsdatum);
		this.ID = naechstID;
		this.bestellung = null;
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

		StringBuffer ausgabe = new StringBuffer();
		ausgabe.append("Kunde: \n");
		ausgabe.append("Id: ");
		ausgabe.append(this.getID()+ "\n");
		ausgabe.append(super.toString());

		if (!hasBestellung()) {
			ausgabe.append("keine ");
		}
		ausgabe.append("Bestellung vorhanden\n");
		
		return ausgabe.toString();
	}

	public boolean hasBestellung() {
		return !(bestellung == null);
	}

}
