import java.io.PrintStream;
import java.util.Scanner;

public class Rettangolo implements FiguraGeometrica{

	public Rettangolo(double base, double altezza){
		this.base=base;
		this.altezza=altezza;
	}
	
	public static Rettangolo read(Scanner sc) throws Exception{
		double base, altezza;
		
		if(!sc.hasNextDouble()) return null;
		base=sc.nextDouble();
		if(!sc.hasNextDouble()) return null;
		altezza=sc.nextDouble();
		
		return new Rettangolo(base, altezza);
	}

	public double calcolaPerimetro(){
		return (base+altezza)*2;
	}

	public double calcolaArea(){
		return base*altezza;
	}
	
	public String toString(){
		return "Rettangolo "+base+"x"+altezza;
	}

	public void print(PrintStream ps){
		ps.println(base+" "+altezza);
	}


	private double base;
	private double altezza;
}