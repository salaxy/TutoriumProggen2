package fhb.pizza.control;

import fhb.pizza.data.GerichtVO;
import fhb.pizza.exceptions.BestellwertNichtErreichtException;
import fhb.pizza.exceptions.GerichtAnzahlUeberschrittenException;
import fhb.pizza.exceptions.GerichtNichtGefundenException;
import fhb.pizza.exceptions.KeinGerichtGewaehltException;
import fhb.pizza.exceptions.PizzaAktionException;

public class BestellService {

	private SpeiseKarte speisekarte;

	private Bestellung aktBestellung;

	private boolean isAktionsWoche;

	public void bestellungAbschlieﬂen() {

		if (aktBestellung != null) {
			try {
				aktBestellung.bestellungAbschliessen();
			} catch (KeinGerichtGewaehltException
					| BestellwertNichtErreichtException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
				}
			} else {
				i++;
			}
		}

		if (!gefunden) {
			throw new GerichtNichtGefundenException();
		}

	}

	public void resetBestellung() {
		aktBestellung = new Bestellung(null, null);
	}
}
