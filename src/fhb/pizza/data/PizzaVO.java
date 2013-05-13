package fhb.pizza.data;

public class PizzaVO extends GerichtVO {

	private int groesse;

	public PizzaVO() {
		this(0, "unbelegte Pizza", 1.0f,
				new String[] { "Kaese", "Tomatensauce" }, 10);
	}

	public PizzaVO(String name) {
		this(0, name, 1.0f, new String[] { "Kaese", "Tomatensauce" }, 10);
	}

	public PizzaVO(String name, float preis) {
		this(0, name, preis, new String[] { "Kaese", "Tomatensauce" }, 10);
	}

	public PizzaVO(int nummer, String name, float preis, String[] zutaten,
			int groesse) {
		super(nummer, name, preis, zutaten);
		this.groesse = groesse;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public boolean equals(Object obj) {
		return (obj instanceof PizzaVO) && super.equals(obj)
				&& this.getGroesse() == ((PizzaVO) obj).getGroesse();
	}

	public int getGroesse() {
		return groesse;
	}

	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}

	public String getGerichtName() {

		StringBuilder ausgabe = new StringBuilder();
		ausgabe.append(this.getName() + " ");

		switch (this.getGroesse()) {
		case 1:
			ausgabe.append("- Normal");
			break;
		case 2:
			ausgabe.append("- Grande");
		}

		return ausgabe.toString();
	}

	public int getGerichtNummer() {
		return (this.getNummer() * 10) + this.getGroesse();
	}

}
