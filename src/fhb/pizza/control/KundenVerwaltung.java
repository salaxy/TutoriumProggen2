package fhb.pizza.control;
import java.util.GregorianCalendar;

import fhb.pizza.data.KundeVO;

public class KundenVerwaltung {

	private int kundenAnz = 2;
	private KundeVO[] kunden;

	public KundenVerwaltung() {
		initKundenVerwaltung();
	}

	public void initKundenVerwaltung() {
		this.kunden= new KundeVO[kundenAnz];
		kunden[0]= new KundeVO("Mustermann", "Max", "m", new GregorianCalendar(1980, 4, 1), "Hauptstraﬂe", "12");
		kunden[1]= new KundeVO("Musterfrau", "Luise", "w", new GregorianCalendar(1989, 7, 3), "Musterweg", "23");
		//  spaeter weitere Kunden
	}

	public String toString() {

		StringBuilder ausgabe = new StringBuilder();
		
		for (int i = 0; i < kunden.length; i++) {
			ausgabe.append(i +"\t");
			ausgabe.append(kunden[i]);
			ausgabe.append("\n");	
		}
	

		return ausgabe.toString();
	}

	public KundeVO[] getKunden() {
		return kunden;
	}

	public void setKunden(KundeVO[] kunden) {
		this.kunden = kunden;
	}

}