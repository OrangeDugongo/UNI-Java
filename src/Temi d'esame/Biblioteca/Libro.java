import java.util.ArrayList;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Iterator;

public class Libro {
	
	public Libro(String id, String titolo, int nAutori, ArrayList<String> autori) {
		this.id = id;
		this.titolo = titolo;
		this.nAutori = nAutori;
		this.autori = autori;
		prestiti=new ArrayList<Prestito>();
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public int getnAutori() {
		return nAutori;
	}
	
	public ArrayList<String> getAutori() {
		return autori;
	}

	public ArrayList<Prestito> getPrestiti() {
		return prestiti;
	}

	public void addPrestito(Prestito p){
		prestiti.add(p);
	}

	public boolean hasAutore(String autore){
		String s=null;
		Iterator<String> iter = autori.iterator();
		boolean trovato=false;
		while(iter.hasNext() && !trovato){
			s=iter.next();
			trovato=s.equals(autore);
		}

		return trovato;
	}
	
	public static Libro read(Scanner sc){
		String id, titolo;
		int nAutori;
		ArrayList<String> autori = new ArrayList<String>();
		
		if(!sc.hasNextLine()) return null;
		id=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		titolo=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		nAutori=Integer.parseInt(sc.nextLine());
		for(int i=0;i<nAutori;i++){
			if(!sc.hasNextLine()) return null;
			autori.add(sc.nextLine());
		}

		return new Libro(id, titolo, nAutori, autori);
	}

	public void print(PrintStream ps){
		ps.println(id);
		ps.println(titolo);
		ps.println(nAutori);
		for(int i=0;i<nAutori;i++)
			ps.println(autori.get(i));
	}

	public void printPrestiti(PrintStream ps){
		for(Prestito p: prestiti)
			ps.println(p.toString());
	}

	public String toString(){
		String stringa=id+" "+titolo+" ";
		for(String s: autori)
			stringa+=s+" ";

		return stringa;
	}


	private String id;
	private String titolo;
	private int nAutori;
	private ArrayList<String> autori;
	private ArrayList<Prestito> prestiti;
}
