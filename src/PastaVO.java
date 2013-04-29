public class PastaVO extends GerichtVO {

	private int pastaSorte;

	public PastaVO() {
		this(0, "Spaghetti mit Tomatensoße", 1.0f, new String[] { "Spaghetti",
				"Tomatensauce" }, 1);
	}

	public PastaVO(String name) {
		this(0, name, 1.0f, new String[] { "Kaese", "Tomatensauce" }, 1);
	}

	public PastaVO(String name, float preis) {
		this(0, name, preis, new String[] { "Kaese", "Tomatensauce" }, 1);
	}

	public PastaVO(int nummer, String name, float preis, String[] zutaten,
			int pastaSorte) {
		super(nummer, name, preis, zutaten);
		this.pastaSorte = pastaSorte;
	}

	public PastaVO clone() {
		PastaVO pizza = new PastaVO(this.getNummer(), this.getName(),
				this.getPreis(), this.getZutaten(), this.getPastaSorte());
		return pizza;
	}

	public boolean equals(Object obj) {
		return (obj instanceof PastaVO) && super.equals(obj)
				&& this.getPastaSorte() == ((PastaVO) obj).getPastaSorte();
	}

	public String getGerichtName() {
		
		StringBuilder ausgabe = new StringBuilder();
		ausgabe.append(this.getName()+" ");

		switch (this.getPastaSorte()) {
			case 4: ausgabe.append("- Spaghetti");
			break;
			case 5: ausgabe.append("- Tortellini");
			break;
			case 6: ausgabe.append("- Gnocchi");
		}

		return ausgabe.toString();
	}

	public int getPastaSorte() {
		return pastaSorte;
	}

	public void setPastaSorte(int pastaSorte) {
		this.pastaSorte = pastaSorte;
	}
	
	public int getGerichtNummer() {
		return (this.getPastaSorte()*100)+this.getNummer();
	}

}
