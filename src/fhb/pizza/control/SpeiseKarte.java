package fhb.pizza.control;
import fhb.pizza.data.DessertVO;
import fhb.pizza.data.GerichtVO;
import fhb.pizza.data.PastaVO;
import fhb.pizza.data.PizzaVO;

public class SpeiseKarte {

	private GerichtVO[] speisen;

	public SpeiseKarte() {
		initSpeiseKarte();
	}

	public void initSpeiseKarte() {
		this.speisen= new GerichtVO[18];
		
		speisen[0]= new PizzaVO(30, "Popeye", 7.00f, new String[]{"Schinken", "Spinat", "Champignon", "Ei"}, 1);
		speisen[1]= new PizzaVO(30, "Popeye", 8.90f, new String[]{"Schinken", "Spinat", "Champignon", "Ei"}, 2);
		
		speisen[2]= new PizzaVO(31, "Hawaii", 5.80f, new String[]{"Schinken", "Ananas", "Curry",}, 1);
		speisen[3]= new PizzaVO(31, "Hawaii", 7.40f, new String[]{"Schinken", "Ananas", "Curry",}, 2);
		
		speisen[4]= new PizzaVO(32, "Prima", 7.00f, new String[]{"Schinken", "Salami", "Zwiebeln", "Ei"}, 1);
		speisen[5]= new PizzaVO(32, "Prima", 8.90f, new String[]{"Schinken", "Salami", "Zwiebeln", "Ei"}, 2);	
	
		speisen[6]=new PastaVO(11, "Napoli", 5.60f, new String[]{"Tomatensauce", "Nudeln"}, 4);
		speisen[7]=new PastaVO(11, "Napoli", 5.60f, new String[]{"Tomatensauce", "Nudeln"}, 5);
		speisen[8]=new PastaVO(11, "Napoli", 5.60f, new String[]{"Tomatensauce", "Nudeln"}, 6);
		
		speisen[9]=new PastaVO(12, "Bolognese", 6.40f, new String[]{"Hackfleischsauce", "Nudeln"}, 4);
		speisen[10]=new PastaVO(12, "Bolognese", 6.40f, new String[]{"Hackfleischsauce", "Nudeln"}, 5);
		speisen[11]=new PastaVO(12, "Bolognese", 6.40f, new String[]{"Hackfleischsauce", "Nudeln"}, 6);
				
		speisen[12]=new PastaVO(13, "alla Panna", 6.40f, new String[]{"Schinken", "Sahne", "Nudeln"}, 4);
		speisen[13]=new PastaVO(13, "alla Panna", 6.40f, new String[]{"Schinken", "Sahne", "Nudeln"}, 5);
		speisen[14]=new PastaVO(13, "alla Panna", 6.40f, new String[]{"Schinken", "Sahne", "Nudeln"}, 6);
				
		speisen[15]=new DessertVO(21, "Hausgemachter Salat", 2.30f);
		speisen[16]=new DessertVO(22, "Hausgemachte Panacotta", 2.60f);
//		speisen[17]=new DessertVO(23, "Hausgemachte Tiramisu", 2.80f);
		
		try {
			speisen[17]=(GerichtVO) speisen[16].clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String toString() {

		StringBuffer ausgabe = new StringBuffer();

		for (GerichtVO gericht : speisen) {
			ausgabe.append(gericht);
		}

		ausgabe.append("Wir wünschen guten Appetit");
		
		return ausgabe.toString();
	}

}
