package fhb.pizza.start;

import java.util.GregorianCalendar;

import fhb.pizza.control.KundenVerwaltung;
import fhb.pizza.control.SpeiseKarte;

public class TestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GregorianCalendar heute = new GregorianCalendar();
		
//		GregorianCalendar datum = new GregorianCalendar(2000, 4, 1);
//		GregorianCalendar datum1 = new GregorianCalendar(2013, 4, 10);
//		GregorianCalendar datum2 = new GregorianCalendar(1988, 4, 5);
//		GregorianCalendar datum3 = new GregorianCalendar(1988, 4, 27);
//		GregorianCalendar datum4 = new GregorianCalendar(2013, 4, 1);


		SpeiseKarte karte = new SpeiseKarte();
		
		KundenVerwaltung verwaltung = new KundenVerwaltung();
		
		System.out.print(karte);
		System.out.print(verwaltung);
		
	}

}
