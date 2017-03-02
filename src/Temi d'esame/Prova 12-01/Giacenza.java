import java.util.Scanner;
import java.io.PrintStream;

public class Giacenza {
	
	public Giacenza(String codeM, String codeP, int quantità) {
		this.codeM = codeM;
		this.codeP = codeP;
		this.quantità = quantità;
		magazino=null;
		prodotto=null;
	}
	
	
	
	
	
	// GET&&SET
	public String getCodeM() {
		return codeM;
	}
	
	public void setCodeM(String codeM) {
		this.codeM = codeM;
	}
	
	public String getCodeP() {
		return codeP;
	}
	
	public void setCodeP(String codeP) {
		this.codeP = codeP;
	}
	
	public int getQuantità() {
		return quantità;
	}
	
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

	public Magazzino getMagazzino(){
		return magazino;
	}
	
	public void setMagazzino(Magazzino m){
		this.magazino=m;
	}

	public Prodotto getProdotto(){
		return prodotto;
	}

	public void setProdotto(Prodotto p){
		this.prodotto=p;
	}
	
	
	
	
	// I/O
	
	public static Giacenza read(Scanner sc){
		String codeM, codeP;
		int quantità;
		
		if(!sc.hasNextLine()) return null;
		codeM=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		codeP=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		quantità=Integer.parseInt(sc.nextLine());

		return new Giacenza(codeM, codeP, quantità);
	}

	public void print(PrintStream ps){
		ps.println(codeM);
		ps.println(codeP);
		ps.println(quantità);
	}

	public String toString(){
		return codeM+" "+codeP+" "+quantità;
	}

	private String codeM;
	private String codeP;
	private int quantità;
	private Magazzino magazino;
	private Prodotto prodotto;
}
