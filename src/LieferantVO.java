import java.util.GregorianCalendar;


public class LieferantVO extends AngestellterVO implements Fahrer{




	public LieferantVO(String fahrzeug, int personalNummer, float gehalt,
			int urlaubsTage, String nachname, String vorname, String strasse,
			String hausNr, String geschlecht, GregorianCalendar geburtsdatum) {
		
		super(personalNummer, gehalt, urlaubsTage, nachname, vorname, strasse,
				hausNr, geschlecht, geburtsdatum);

//		this.fahrzeug = fahrzeug;
		//TODO ???
	}

	public boolean equals(Object o) {
		//TODO
//		if (!(o instanceof KochVO)) {
//			return false;
//		} else {
//
//			KochVO andererKoch = (KochVO) o;
//
//			if (this.getVorName().compareToIgnoreCase(andererKoch.getVorName()) == 0
//					&& (this.getNachName().compareToIgnoreCase(andererKoch
//							.getNachName()) == 0)) {
//				return this.farbeSchurze.equals(andererKoch.getFarbeSchurze());
//			}
//
			return false;
//		}
	}

	public String toString() {

		return "Lieferant:" + this.getVorName() + ", " + this.getNachName() + ", "
				+ this.getFahrzeug() + ", "+ this.getKilometerstand();
	}

	public String getFahrzeug() {
		return fahrzeug;
	}



	public int getKilometerstand() {
		return kilometerstand;
	}


	@Override
	public void arbeiteInPizzeria() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void arbeite() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fahreFahrzeug() {
		// TODO Auto-generated method stub
		
	}

}