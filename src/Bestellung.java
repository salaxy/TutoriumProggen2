import java.util.GregorianCalendar;
import java.util.Locale;


public class Bestellung {

	private GregorianCalendar bestelldatum;
	private GregorianCalendar auslieferungsdatum;
	private int index;
	private PizzaVO[] warenkorb;
	private KundeVO kunde;

	private final int MAX_GERICHTE = 10;

	public Bestellung(GregorianCalendar bestelldatum, KundeVO kunde) {
		this.index = 0;
		this.warenkorb = new PizzaVO[10];
		this.bestelldatum = bestelldatum;
		this.kunde = kunde;
	}

	public void hinzufuegenGericht(PizzaVO neuePizza) {
		// if(index>=warenkorb.length){ //alternativ(besser)
		if (index >= MAX_GERICHTE) {
			System.out.println("Warenkorb voll");
		} else {
			warenkorb[index] = neuePizza;
			index++;
		}
	}

	public void loescheLetztesGericht() {
		if (index > 0) {
			warenkorb[index - 1] = null;
			index--;
		}
	}

	public PizzaVO getGericht(int index) {
		return warenkorb[index];
	}

	int getAnzGerichte() {
		return index;
	}

	float berechneGesamtpreis() {

		float summe = 0.0f;

		for (PizzaVO aktPizza : warenkorb) {
			if (aktPizza != null)
				summe = summe + aktPizza.getPreis();
		}

		return summe;
	}

	public String toString() {
		String gericht = new String();
		
		gericht = gericht + "Max. Gerichte: " + MAX_GERICHTE;
		gericht = gericht + "\nIndex: " + index;
		gericht = gericht + "\nbestelldatum: " + this.bestelldatum.get(GregorianCalendar.DAY_OF_MONTH)
				+ ". " + this.bestelldatum.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.SHORT, new Locale("de"))
				+ " " + this.bestelldatum.get(GregorianCalendar.HOUR_OF_DAY)
				+ String.format(":%02d Uhr", this.bestelldatum.get(GregorianCalendar.MINUTE));
		gericht = gericht + ((auslieferungsdatum != null) ? ("\nauslieferungsdatum: "
				+ this.auslieferungsdatum.get(GregorianCalendar.DAY_OF_MONTH)
				+ ":" + this.auslieferungsdatum.get(GregorianCalendar.HOUR_OF_DAY)
				+ ":" + this.auslieferungsdatum.get(GregorianCalendar.MINUTE)) : "\nauslieferungsdatum: ???");
		gericht = gericht + "\nKunde: " + this.kunde.toString();
		gericht = gericht + "\nGerichte (" + this.getAnzGerichte() +"):\n";
		
		for (PizzaVO aktGericht : warenkorb) {
			gericht = gericht + "          " + ((aktGericht != null) ? aktGericht.toString() + "\n" : "");
		}

		gericht = gericht + "\n\nGesamtpreis: " + String.format("%1.2f", this.berechneGesamtpreis());

		return gericht;
	}

	public GregorianCalendar getbestelldatum() {
		return bestelldatum;
	}

	public void setbestelldatum(GregorianCalendar bestelldatum) {
		this.bestelldatum = bestelldatum;
	}

	public GregorianCalendar getauslieferungsdatum() {
		return auslieferungsdatum;
	}

	public void setauslieferungsdatum(GregorianCalendar auslieferungsdatum) {
		this.auslieferungsdatum = auslieferungsdatum;
	}

}
