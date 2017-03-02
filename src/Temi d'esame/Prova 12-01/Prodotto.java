import java.util.Scanner;
import java.util.LinkedList;
import java.io.PrintStream;

public class Prodotto {
	
	public Prodotto(String codeP, String descrizione, double prezzo) {
		this.codeP = codeP;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		giacenze=new LinkedList<Giacenza>();
		magazzini=new LinkedList<Magazzino>();
	}
	
	public String getCodeP() {
		return codeP;
	}
	
	public void setCodeP(String codeP) {
		this.codeP = codeP;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public LinkedList<Giacenza> getGiacenze(){
		return giacenze;
	}

	public void addGiacenza(Giacenza g){
		giacenze.add(g);
	}

	public LinkedList<Magazzino> getMagazzini(){
		return magazzini;
	}

	public void addMagazzino(Magazzino m){
		magazzini.add(m);
	}

	public static Prodotto read(Scanner sc){
		String codeP, descrizione;
		double prezzo;
		
		if(!sc.hasNext()) return null;
		codeP=sc.nextLine();
		if(!sc.hasNext()) return null;
		descrizione=sc.nextLine();
		if(!sc.hasNext()) return null;
		prezzo=Double.parseDouble(sc.nextLine());

		return new Prodotto(codeP, descrizione, prezzo);
	}

	public void print(PrintStream ps){
		ps.println(codeP);
		ps.println(descrizione);
		ps.println(prezzo);
	}

	public void printGiacenze(PrintStream ps){
		for(Giacenza g: giacenze)
			ps.println(g.toString());
	}

	public void printMagzzini(PrintStream ps){
		for(Magazzino m: magazzini)
			ps.println(m.toString());
	}

	public String toString(){
		return codeP+" "+descrizione+" "+prezzo;
	}

	private String codeP;
	private String descrizione;
	private double prezzo;
	private LinkedList<Giacenza> giacenze;	
	private LinkedList<Magazzino> magazzini;
}
