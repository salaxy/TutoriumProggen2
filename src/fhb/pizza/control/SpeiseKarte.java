package fhb.pizza.control;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import fhb.pizza.data.DessertVO;
import fhb.pizza.data.GerichtVO;
import fhb.pizza.data.PastaVO;
import fhb.pizza.data.PizzaVO;

public class SpeiseKarte {

	private GerichtVO[] speisen;
	
	private final static String SPEISEKARTE_PATH="gerichte.ser";

	public SpeiseKarte() {
		initSpeiseKarte();
	}

	public GerichtVO[] getSpeisen() {
		return speisen;
	}

	public void initSpeiseKarte() {
		
		speisen = new GerichtVO[18];
		
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
		speisen[17]=new DessertVO(23, "Hausgemachte Tiramisu", 2.80f);
		
		schreibeSpeiseKarte();
		leseSpeiseKarte();	
	}

	public String toString() {

		StringBuffer ausgabe = new StringBuffer();

		for (GerichtVO gericht : speisen) {
			ausgabe.append(gericht);
		}

		ausgabe.append("Wir wünschen guten Appetit");
		
		return ausgabe.toString();
	}
	
	
	private void schreibeSpeiseKarte(){
		
        try{
            //zu schreibene Datei erstellen
            FileOutputStream fs= new FileOutputStream(SPEISEKARTE_PATH);
            // Datei öffnen
            ObjectOutputStream os=new ObjectOutputStream(fs);
            // Daten schreiben
            os.writeObject(speisen);
            //Datei schließen
            os.close();
        }catch(IOException e){
	    	System.err.println(e.getMessage());
        }
		
	}
	
	private void leseSpeiseKarte(){
		
		//zwischenspeicher fuer die Rueckgabe
		GerichtVO[] dummy=null;
		
		try{
	        //zu lesende Datei festlegen und öffnen
	        FileInputStream fs= new FileInputStream(SPEISEKARTE_PATH);
	        ObjectInputStream is=new ObjectInputStream(fs);
	        // Datei auslesen
	        dummy=(GerichtVO[])is.readObject();
	        //Datei schließen
	        is.close();
	        speisen=dummy;
	        
	    }catch(ClassNotFoundException e){
	    	System.err.println(e.getMessage());
	    }catch(IOException e){
	    	System.err.println(e.getMessage());
	    }
		
	}

}
