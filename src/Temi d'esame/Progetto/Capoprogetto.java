import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Capoprogetto {
	
	public Capoprogetto(String matricola, String nome, String cognome, Date data) {
		
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.data = data;
		this.progetti = null;
		
	}
	
	public String getMatricola() {
		return matricola;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public ArrayList<Progetto> getProgetto() {
		return progetti;
	}

	public void setProgetto(ArrayList<Progetto> progetti) {
		this.progetti = progetti;
	}

	public Date getData() {
		return data;
	}

	public void addProgetto(Progetto p){
		progetti.add(p);
	}

	public static Capoprogetto read(Scanner sc){
		String matricola, nome, cognome;
		Date data=null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if(!sc.hasNextLine()) return null;
		matricola=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		nome=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		cognome=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		try{
			data=sdf.parse(sc.nextLine());
		}
		catch(ParseException e){
			System.err.println("Impossibile leggere la data. Impostata a zero");
			data=new Date(0);
		}

		return new Capoprogetto(matricola, nome, cognome, data);

	}

	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return matricola+" "+nome+" "+cognome+" "+sdf.format(data);
	}
	
	private String matricola;
	private String nome;
	private String cognome;
	private Date data;
	private ArrayList<Progetto> progetti;
}
