import java.io.PrintStream;
import java.util.Scanner;

public class FiguraRegolare implements FiguraGeometrica{

	public FiguraRegolare(double lato, int nlati, double numeroFisso){
		this.lato=lato;
		this.nlati=nlati;
		apotema=numeroFisso*lato;
	}
	
	public static FiguraRegolare read(Scanner sc) throws Exception{
		double lato, numeroFisso;
		int nlati;
		
		if(!sc.hasNextDouble()) return null;
		lato=sc.nextDouble();
		if(!sc.hasNextDouble()) return null;
		numeroFisso=sc.nextDouble();
		if(!sc.hasNextInt()) return null;
		nlati=sc.nextInt();
		
		return new FiguraRegolare(lato, nlati, numeroFisso);
	}

	public double calcolaPerimetro(){
		return lato*nlati;
	}

	public double calcolaArea(){
		return (calcolaPerimetro()*apotema)/2;
	}
	
	public String toString(){
		return "Figura regolare di "+nlati+" lati lunghi "+lato;
	}

	public void print(PrintStream ps){
		ps.println(lato+" "+apotema/lato+" "+nlati);
	}

	private double lato;
	private double apotema;
	private int nlati;
}