import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Progetto {

	public Progetto(String id, String matricola, Date inizio, Date fine, double importo) {
		super();
		this.id = id;
		this.matricola = matricola;
		this.inizio = inizio;
		this.fine = fine;
		this.importo = importo;
		this.capoprogetto = null;
		
	}
	
	public Date getInizio() {
		return inizio;
	}

	public void setInizio(Date inizio) {
		this.inizio = inizio;
	}

	public Date getFine() {
		return fine;
	}

	public void setFine(Date fine) {
		this.fine = fine;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public String getId() {
		return id;
	}

	public String getMatricola() {
		return matricola;
	}
	
	public Capoprogetto getCapoprogetto() {
		return capoprogetto;
	}

	public void setCapoprogetto(Capoprogetto capoprogetto) {
		this.capoprogetto = capoprogetto;
	}

	public static Progetto read(Scanner sc){
		String id, matricola;
		Date inizio=null, fine=null;
		double importo=1000;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if(!sc.hasNextLine()) return null;
		id=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		matricola=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		try{
			inizio=sdf.parse(sc.nextLine());
		}
		catch(ParseException e){
			System.err.println("Impossibile leggere la data. Impostata a zero");
			inizio=new Date(0);
		}
		if(!sc.hasNextLine()) return null;
		try{
			fine=sdf.parse(sc.nextLine());
		}
		catch(ParseException e){
			System.err.println("Impossibile leggere la data. Impostata a zero");
			fine=new Date(0);
		}
		if(!sc.hasNextLine()) return null;
		try{
			importo = Double.parseDouble(sc.nextLine());
			if(importo<0)
				throw new ImportoNegativo("L'importo del progetto: "+id+" è negativo.");
		}
		catch(NumberFormatException e){
			System.err.println("Impossibile leggere correttamente l'importo del progetto: "+id);
			System.err.println("Importo impostato a 1000");
		}
		catch(ImportoNegativo in){
			System.err.println(in.getMessage());
			System.err.println("Importo inpostato a positivo.");
			importo*=-1;
		}
		

		return new Progetto(id, matricola, inizio, fine, importo);

	}

	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return id+" "+matricola+" "+sdf.format(inizio)+" "+sdf.format(fine)+" "+importo;
	}
	
	private String id;
	private String matricola;
	private Date inizio;
	private Date fine;
	private double importo;
	private Capoprogetto capoprogetto;
	
	
}
