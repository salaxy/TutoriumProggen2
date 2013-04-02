

public class PizzaVO {

	private String name;
	private float preis;
	private String[] zutaten;

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
	
	public PizzaVO(){
		this("unbelegte Pizza", 1.0f, new String[]{"Kaese","Tomatensauce"});
	}
	
	public PizzaVO(String name){
		this(name, 1.0f, new String[]{"Kaese","Tomatensauce"});
	}
	
	public PizzaVO(String name, float preis){
		this(name, preis, new String[]{"Kaese","Tomatensauce"});
	}

	public PizzaVO(String name, float preis, String[] zutaten) {
		super();
		this.name = name;
		this.preis = preis;
		this.zutaten = zutaten;
	}

	public PizzaVO clone() {
		PizzaVO pizza = new PizzaVO(this.getName(), this.getPreis(),
				this.getZutaten());
		return pizza;
	}

	public boolean equals(Object obj) {
		PizzaVO anderePizza = null;

		boolean isEqual = false;
		if (obj instanceof PizzaVO) {
			anderePizza = (PizzaVO) obj;
		} else {
			return false;
		}

		if (this.name.compareToIgnoreCase(anderePizza.getName()) == 0) {

			if (this.preis == anderePizza.getPreis()) {

				if (this.zutaten.length != anderePizza.getZutaten().length) {
					return false;
				}

				for (int i = 0; i < anderePizza.getZutaten().length; i++) {
					isEqual = this.zutaten[i].compareToIgnoreCase(anderePizza
							.getZutaten()[i]) == 0 && isEqual;
				}

				return isEqual;
			}

		}

		return false;
	}
	
	public String toString(){
		return "Pizza: "+this.name +", " + this.preis;
		
	}

}
