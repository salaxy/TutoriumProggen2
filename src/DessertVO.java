public class DessertVO extends GerichtVO {

	public DessertVO() {
		this(1, "Teramisu", 1.0f);
	}

	public DessertVO(int nummer) {
		this(nummer, "Teramisu", 1.0f);
	}

	public DessertVO(int nummer, String name, float preis) {
		super(nummer, name, preis, new String[] { "Sahne", "Geheime Zutat" });
	}

	public DessertVO clone() {
		DessertVO dessert = new DessertVO(this.getNummer(), this.getName(),
				this.getPreis());
		return dessert;
	}

	public boolean equals(Object obj) {
		return (obj instanceof DessertVO) && super.equals(obj);
	}

	public int getGerichtNummer() {
		return this.getNummer();
	}

	@Override
	protected String getGerichtName() {
		return this.getName();
	}

}
