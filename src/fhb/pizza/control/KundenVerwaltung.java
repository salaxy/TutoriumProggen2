package fhb.pizza.control;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;

import fhb.pizza.data.KundeVO;

public class KundenVerwaltung {

//	private int kundenAnz = 2;
//	private KundeVO[] kunden;
	private ArrayList<KundeVO> kunden= new ArrayList<KundeVO>();

	public KundenVerwaltung() {
		initKundenVerwaltung();
	}

	public void initKundenVerwaltung() {
//		this.kunden= new KundeVO[kundenAnz];
		kunden.add(new KundeVO("Mustermann", "Max", "m", new GregorianCalendar(1980, 4, 1), "Hauptstraﬂe", "12"));
		kunden.add(new KundeVO("Musterfrau", "Luise", "w", new GregorianCalendar(1989, 7, 3), "Musterweg", "23"));
		//  spaeter weitere Kunden
	}

	public String toString() {

		StringBuilder ausgabe = new StringBuilder();
		
//		for (int i = 0; i < kunden.length; i++) {
//			ausgabe.append(i +"\t");
//			ausgabe.append(kunden[i]);
//			ausgabe.append("\n");	
//		}
		
		for (KundeVO kunde : kunden) {
			ausgabe.append(kunden.indexOf(kunde) +"\t");
			ausgabe.append(kunde);
			ausgabe.append("\n");	
		}
	

		return ausgabe.toString();
	}

	public KundeVO[] getKunden() {
		
		Collections.sort(kunden);
		Object[] o= kunden.toArray();
		return Arrays.copyOf(o, o.length, KundeVO[].class);
	}

//	public void setKunden(KundeVO[] kunden) {
//		this.kunden = kunden;
//	}

}