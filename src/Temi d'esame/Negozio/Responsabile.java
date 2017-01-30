import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Responsabile {
	
	

	public Responsabile(String matricola, String nome, String cnome, Date dataNascita, String comuneNascita) {
		
		this.matricola = matricola;
		this.nome = nome;
		this.cnome = cnome;
		this.dataNascita = dataNascita;
		this.comuneNascita = comuneNascita;
		this.negozi = new ArrayList<Negozio>(); //inizializzato
		
		
	}
	
	public String getMatricola() {
		return matricola;
	}

	public String getNome() {
		return nome;
	}

	public String getCnome() {
		return cnome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public String getComuneNascita() {
		return comuneNascita;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return matricola+" "+nome+ " "+cnome+" "+sdf.format(dataNascita)+" "+comuneNascita;
	}

	public ArrayList<Negozio> getNegozi() {
		return negozi;
	}

	public void setNegozi(ArrayList<Negozio> negozi) {
		this.negozi = negozi;
	}

	public void addNegozio(Negozio n){
		negozi.add(n);
		
	}

	public void printNegozi(PrintStream ps){
		for(Negozio n: negozi)
			ps.println(n.toString());
	}

	public static Responsabile read(Scanner sc){
		String matricola, nome, cnome, comuneNascita;
		Date dataNascita;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if(!sc.hasNextLine()) return null;
		matricola=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		nome=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		cnome=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		try{
			dataNascita=sdf.parse(sc.nextLine());
		}
		catch(ParseException e){
			System.err.println("Impossibile leggere la data di nascita, impostata a base.");
			dataNascita=new Date(0);
		}
		if(!sc.hasNextLine()) return null;
		comuneNascita=sc.nextLine();

		return new Responsabile(matricola, nome, cnome, dataNascita, comuneNascita);
	}

	public void print(PrintStream ps){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ps.println(matricola);
		ps.println(nome);
		ps.println(cnome);
		ps.println(sdf.format(dataNascita));
		ps.println(comuneNascita);
	}

	private String matricola;
	private String nome;
	private String cnome;
	private Date dataNascita;
	private String comuneNascita;
	private ArrayList<Negozio> negozi;
	
	
}
