package fhb.pizza.control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Locale;

import fhb.pizza.data.GerichtVO;
import fhb.pizza.data.KundeVO;
import fhb.pizza.exceptions.BestellwertNichtErreichtException;
import fhb.pizza.exceptions.GerichtAnzahlUeberschrittenException;
import fhb.pizza.exceptions.KeinGerichtGewaehltException;

public class Bestellung {

	private final static float MINDESTBESTELLWERT = 10.00f;

	private GregorianCalendar bestelldatum;
	private GregorianCalendar auslieferungsdatum;
	private int index = 0;
	private GerichtVO[] warenkorb;
	private KundeVO kunde;

	private final int MAX_GERICHTE = 10;

	public Bestellung(GregorianCalendar bestelldatum, KundeVO kunde) {
		this.warenkorb = new GerichtVO[10];
		this.bestelldatum = bestelldatum;
		this.kunde = kunde;
		kunde.setBestellung(this);
	}

	public void hinzufuegenGericht(GerichtVO neuePizza)
			throws GerichtAnzahlUeberschrittenException {

		// if(index>=warenkorb.length){ //alternativ

		if (index >= MAX_GERICHTE) {
			System.out.println("Warenkorb voll");
			throw new GerichtAnzahlUeberschrittenException();
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

	public GerichtVO getGericht(int index) {
		return warenkorb[index];
	}

	int getAnzGerichte() {
		return index;
	}

	float berechneGesamtpreis() {

		float summe = 0.0f;

		for (GerichtVO aktPizza : warenkorb) {
			if (aktPizza != null)
				summe = summe + aktPizza.getPreis();
		}

		return summe;
	}

	public String toString() {
		String gericht = new String();

		gericht = gericht + "Max. Gerichte: " + MAX_GERICHTE;
		gericht = gericht + "\nIndex: " + index;
		gericht = gericht
				+ "\nbestelldatum: "
				+ this.bestelldatum.get(GregorianCalendar.DAY_OF_MONTH)
				+ ". "
				+ this.bestelldatum.getDisplayName(GregorianCalendar.MONTH,
						GregorianCalendar.SHORT, new Locale("de"))
				+ " "
				+ this.bestelldatum.get(GregorianCalendar.HOUR_OF_DAY)
				+ String.format(":%02d Uhr",
						this.bestelldatum.get(GregorianCalendar.MINUTE));
		gericht = gericht
				+ ((auslieferungsdatum != null) ? ("\nauslieferungsdatum: "
						+ this.auslieferungsdatum
								.get(GregorianCalendar.DAY_OF_MONTH)
						+ ":"
						+ this.auslieferungsdatum
								.get(GregorianCalendar.HOUR_OF_DAY) + ":" + this.auslieferungsdatum
						.get(GregorianCalendar.MINUTE))
						: "\nauslieferungsdatum: ???");
		gericht = gericht + "\nKunde: " + this.kunde.toString();
		gericht = gericht + "\nGerichte (" + this.getAnzGerichte() + "):\n";

		for (GerichtVO aktGericht : warenkorb) {
			gericht = gericht
					+ "          "
					+ ((aktGericht != null) ? aktGericht.toString() + "\n" : "");
		}

		gericht = gericht + "\n\nGesamtpreis: "
				+ String.format("%1.2f", this.berechneGesamtpreis());

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

	public void bestellungAbschliessen() throws KeinGerichtGewaehltException,
			BestellwertNichtErreichtException {

		if (this.index == 0) {
			throw new KeinGerichtGewaehltException(
					"Es wurde Kein Gericht gewählt, "
							+ "Sie können die Bestellung nicht abschließen!");
		}

		if (this.berechneGesamtpreis() >= MINDESTBESTELLWERT) {
			throw new BestellwertNichtErreichtException(
					"Der  Mindestbestellwert wurde nicht erreicht");
		}
	}

	public void schreibeBestellung(String fileName) throws IOException {

		// öffnen der Datei
		BufferedWriter dateischreiber = new BufferedWriter(new FileWriter(
				new File(fileName)));
		// schreiben der Daten
		dateischreiber.write(this.toString());
		// schließen der Datei
		dateischreiber.close();

	}

}
