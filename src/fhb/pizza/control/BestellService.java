package fhb.pizza.control;

import java.util.GregorianCalendar;

import fhb.pizza.data.GerichtVO;
import fhb.pizza.data.KundeVO;
import fhb.pizza.exceptions.BestellwertNichtErreichtException;
import fhb.pizza.exceptions.GerichtAnzahlUeberschrittenException;
import fhb.pizza.exceptions.GerichtNichtGefundenException;
import fhb.pizza.exceptions.KeinGerichtGewaehltException;
import fhb.pizza.exceptions.PizzaAktionException;

public class BestellService {

	private SpeiseKarte speisekarte;

	private Bestellung aktBestellung;
	
	private KundenVerwaltung kundenstamm;

	private boolean isAktionsWoche;
	
	public BestellService(){
		aktBestellung = new Bestellung(new GregorianCalendar(), kundenstamm.getKunden()[0]);
	}

	public void bestellungAbschlieﬂen() throws KeinGerichtGewaehltException, BestellwertNichtErreichtException  {
		
		if (aktBestellung != null) {
				aktBestellung.bestellungAbschliessen();
		}
	}


	public void waehleGericht(int nummer)
			throws GerichtAnzahlUeberschrittenException,
			GerichtNichtGefundenException, PizzaAktionException {

		GerichtVO[] liste = this.speisekarte.getSpeisen();
		int i = 0;
		boolean gefunden = false;

		while ((i < liste.length) && !gefunden) {

			if ((liste[i] != null) && liste[i].getGerichtNummer() == nummer) {
				gefunden = true;

				if (!isAktionsWoche) {
					aktBestellung.hinzufuegenGericht(liste[i]);
					System.out.println(nummer + " hinzugefuegt");
				}else{
					//TODO falls Aktionswoche, dann ueberpr¸fen ob
					//dieses Gericht eine Pizza PopeyeNormal ist ....usw.
				}
			} else {
				i++;
			}
		}

		if (!gefunden) {
			throw new GerichtNichtGefundenException();
		}

	}
	
	public boolean isAktionsWoche() {
		return isAktionsWoche;
	}

	public void setAktionsWoche(boolean isAktionsWoche) {
		this.isAktionsWoche = isAktionsWoche;
	}

	public SpeiseKarte getSpeisekarte() {
		return speisekarte;
	}

	public Bestellung getAktBestellung() {
		return aktBestellung;
	}

	public KundenVerwaltung getKundenstamm() {
		return kundenstamm;
	}

	public void bestellungAufgeben(KundeVO kunde){
		aktBestellung = new Bestellung(new GregorianCalendar(), kunde);
	}

	public void resetBestellung() {
		aktBestellung = new Bestellung(new GregorianCalendar(), kundenstamm.getKunden()[0]);
	}
	
	public void letzteEingabeLoeschen(){
		this.aktBestellung.loescheLetztesGericht();
	}
}
