
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

	public PizzaVO clone() {
		PizzaVO pizza = new PizzaVO(this.getNummer(), this.getName(),
				this.getPreis(), this.getZutaten(), this.getGroesse());
		return pizza;
	}

	public boolean equals(Object obj) {
		return (obj instanceof PizzaVO) && super.equals(obj)
				&& this.getGroesse() == ((PizzaVO) obj).getGroesse();
	}

	public String toString() {
		return "Pizza: " + this.name + ", " + this.preis;
		//TODO Vervollstaendigung
	}

	public int getGroesse() {
		return groesse;
	}

	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}

}
