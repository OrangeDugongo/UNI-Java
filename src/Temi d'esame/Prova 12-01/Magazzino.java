import java.util.Scanner;
import java.util.LinkedList;
import java.io.PrintStream;

public class Magazzino {
	
	public Magazzino(String codeM, String indirizzo, String città, String nazione, String telefono, String fax) {
		this.codeM = codeM;
		this.indirizzo = indirizzo;
		this.città = città;
		this.nazione = nazione;
		this.telefono = telefono;
		this.fax = fax;
		giacenze=new LinkedList<Giacenza>();
		prodotti=new LinkedList<Prodotto>();
	}

	public Magazzino() {
		this.codeM = "DEF";
		giacenze=new LinkedList<Giacenza>();
		prodotti=new LinkedList<Prodotto>();
	}
	
	public String getCodeM() {
		return codeM;
	}
	
	public void setCodeM(String codeM) {
		this.codeM = codeM;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public String getCittà() {
		return città;
	}
	
	public String getNazione() {
		return nazione;
	}

	public LinkedList<Giacenza> getGiacenze(){
		return giacenze;
	}

	public void addGiacenza(Giacenza g){
		giacenze.add(g);
	}

	public LinkedList<Prodotto> getProdotti(){
		return prodotti;
	}

	public void addProdotto(Prodotto p){
		prodotti.add(p);
	}

	public static Magazzino read(Scanner sc){
		String codeM, indirizzo, città, nazione, telefono, fax;
		
		if(!sc.hasNext()) return null;
		codeM=sc.nextLine();
		if(!sc.hasNext()) return null;
		indirizzo=sc.nextLine();
		if(!sc.hasNext()) return null;
		città=sc.nextLine();
		if(!sc.hasNext()) return null;
		nazione=sc.nextLine();
		if(!sc.hasNext()) return null;
		telefono=sc.nextLine();
		if(!sc.hasNext()) return null;
		fax=sc.nextLine();

		return new Magazzino(codeM, indirizzo, città, nazione, telefono, fax);
	}

	public void print(PrintStream ps){
		ps.println(codeM);
		ps.println(indirizzo);
		ps.println(città);
		ps.println(nazione);
		ps.println(telefono);
		ps.println(fax);
	}

	public void printGiacenze(PrintStream ps){
		for(Giacenza g: giacenze)
			ps.println(g.toString());
	}

	public void printProdotti(PrintStream ps){
		for(Prodotto p: prodotti)
			ps.println(p.toString());
	}

	public String toString(){
		return codeM+" "+indirizzo+" "+città+" "+nazione;
	}

	private String codeM;
	private String indirizzo;
	private String città;
	private String nazione;
	private String telefono;
	private String fax;
	private LinkedList<Giacenza> giacenze;	
	private LinkedList<Prodotto> prodotti;
}
