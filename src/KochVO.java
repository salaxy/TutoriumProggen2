import java.awt.Color;

public class KochVO {

	private String nachname;
	private String vorname;
	private Color farbeSchurze;

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Color getFarbeSchurze() {
		return farbeSchurze;
	}

	public void setFarbeSchurze(Color farbeSchurze) {
		this.farbeSchurze = farbeSchurze;
	}

	public KochVO() {
		this("Koch", "Meister", Color.BLUE);
	}

	public KochVO(String nachname, String vorname) {
		this(nachname, vorname, Color.BLUE);
	}

	public KochVO(String nachname, String vorname, Color farbeSchurze) {
		super();
		this.nachname = nachname;
		this.vorname = vorname;
		this.farbeSchurze = farbeSchurze;
	}

	public boolean equals(Object o) {
		if (!(o instanceof KochVO)) {
			return false;
		} else {

			KochVO andererKoch = (KochVO) o;

			if (this.vorname.compareToIgnoreCase(andererKoch.getVorname()) == 0
					&& (this.nachname.compareToIgnoreCase(andererKoch
							.getNachname()) == 0)) {
				return this.farbeSchurze.equals(andererKoch.getFarbeSchurze());
			}

			return false;
		}
	}

	public String toString() {

		return "Koch: " + this.getVorname() + ", " + this.getNachname() + ", "
				+ this.getFarbeSchurze().getRGB();
	}

}
