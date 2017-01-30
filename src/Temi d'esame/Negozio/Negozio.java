import java.util.Date;
import java.util.Scanner;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Negozio {
	

	public Negozio(String iD, String matricola, Date dataApertura, Date dataChiusura, String ubicazione) {
		ID = iD;
		this.matricola = matricola;
		this.dataApertura = dataApertura;
		this.dataChiusura = dataChiusura;
		this.ubicazione = ubicazione;
	}
	
	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Date getdataChiusura() {
		return dataChiusura;
	}

	public void setdataChiusura(Date dataChiusura) {
		this.dataChiusura = dataChiusura;
	}

	public String getID() {
		return ID;
	}

	public Date getDataApertura() {
		return dataApertura;
	}

	public String getUbicazione() {
		return ubicazione;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return ID+" "+matricola+" "+sdf.format(dataApertura)+"-"+sdf.format(dataChiusura)+ " "+ubicazione;
	}

	public Responsabile getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(Responsabile responsabile) {
		this.responsabile = responsabile;
	}

	public static Negozio read(Scanner sc){
		String ID, matricola, ubicazione;
		Date dataApertura;
		Date dataChiusura;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if(!sc.hasNextLine()) return null;
		ID=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		matricola=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		try{
			dataApertura=sdf.parse(sc.nextLine());
		}
		catch(ParseException e){
			System.err.println("Impossibile leggere la data di inizio attività");
			dataApertura=new Date(0);
		}
		if(!sc.hasNextLine()) return null;
		try{
			dataChiusura=sdf.parse(sc.nextLine());
		}
		catch(ParseException e){
			System.err.println("Impossibile leggere la data di fine attività attività");
			dataChiusura=new Date();
		}
		if(!sc.hasNextLine()) return null;
		ubicazione=sc.nextLine();

		return new Negozio(ID, matricola, dataApertura, dataChiusura, ubicazione);
	}

	public void print(PrintStream ps){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ps.println(ID);
		ps.println(matricola);
		ps.println(sdf.format(dataApertura));
		ps.println(sdf.format(dataChiusura));
		ps.println(ubicazione);
	}
	


	private String ID;
	private String matricola;
	private Date dataApertura;
	private Date dataChiusura;
	private String ubicazione;
	private Responsabile responsabile;
	
	
}
