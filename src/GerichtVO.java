public abstract class GerichtVO {

	protected int nummer;
	protected String name;
	protected float preis;
	protected String[] zutaten;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPreis() {
		return preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	public String[] getZutaten() {
		return zutaten;
	}

	public void setZutaten(String[] zutaten) {
		this.zutaten = zutaten;
	}

	public GerichtVO() {
		this(0, "leerer Teller", 1.0f, new String[] { "Gabel", "Messer",
				"Teller" });
	}

	public GerichtVO(int nummer, String name, float preis, String[] zutaten) {
		super();
		this.nummer = nummer;
		this.name = name;
		this.preis = preis;
		this.zutaten = zutaten;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

//	public GerichtVO clone() {
//		GerichtVO gericht = new GerichtVO(this.getNummer(), this.getName(),
//				this.getPreis(), this.getZutaten());
//		return gericht;
//	}

	public boolean equals(Object obj) {
		GerichtVO anderesGericht = null;

		boolean isEqual = false;
		if (obj instanceof GerichtVO) {
			anderesGericht = (GerichtVO) obj;
		} else {
			return false;
		}

		if (this.name.compareToIgnoreCase(anderesGericht.getName()) == 0) {

			if (this.preis == anderesGericht.getPreis()) {

				if (this.zutaten.length != anderesGericht.getZutaten().length) {
					return false;
				}

				for (int i = 0; i < anderesGericht.getZutaten().length; i++) {
					isEqual = this.zutaten[i]
							.compareToIgnoreCase(anderesGericht.getZutaten()[i]) == 0
							&& isEqual;
				}

				return isEqual;
			}

		}

		return false;
	}
	
	public String getFormatedPreis(){
		return String.format("%.2f", this.getPreis());
	}

	public String toString() {
		
		StringBuilder ausgabe=new StringBuilder();
		
		ausgabe.append(this.getGerichtNummer() + "\t");
		ausgabe.append(this.getGerichtName() + ", ");
		ausgabe.append(this.getFormatedPreis() + "\n");
		
		for (int i = 0; i < this.getZutaten().length; i++) {
			ausgabe.append(this.zutaten[i]);
			if(i!=this.getZutaten().length-1){
				ausgabe.append(", ");	
			}
		}
		ausgabe.append("\n");
		
		return ausgabe.toString();
	}

	protected abstract int getGerichtNummer();
	protected abstract String getGerichtName();
}
