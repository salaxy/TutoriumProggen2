package fhb.pizza.start;

import java.util.GregorianCalendar;

import fhb.pizza.control.Bestellung;
import fhb.pizza.control.KundenVerwaltung;
import fhb.pizza.control.SpeiseKarte;
import fhb.pizza.exceptions.GerichtAnzahlUeberschrittenException;

public class TestDriver {

	public static void main(String[] args) {

		GregorianCalendar heute = new GregorianCalendar();

		SpeiseKarte karte = new SpeiseKarte();
		
		KundenVerwaltung verwaltung = new KundenVerwaltung();
		
		System.out.print(karte);
		System.out.print(verwaltung);
		
		KundenVerwaltung kundenVerwaltung= new KundenVerwaltung();
		
		Bestellung bestellung = new Bestellung(heute, kundenVerwaltung.getKunden()[0]);
		
		try {
			bestellung.hinzufuegenGericht(karte.getSpeisen()[1]);
			bestellung.hinzufuegenGericht(karte.getSpeisen()[2]);
			bestellung.hinzufuegenGericht(karte.getSpeisen()[5]);
			bestellung.hinzufuegenGericht(karte.getSpeisen()[6]);
		} catch (GerichtAnzahlUeberschrittenException e) {
			e.printStackTrace();
		}
		
		System.out.println(bestellung);
		
	}

}
