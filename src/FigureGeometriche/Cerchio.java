import java.io.PrintStream;
import java.util.Scanner;

public class Cerchio implements FiguraGeometrica{

	public Cerchio(double raggio){
		this.raggio=raggio;
	}
	
	public static Cerchio read(Scanner sc) throws Exception{
		if(!sc.hasNextDouble()) return null;
		
		return new Cerchio(sc.nextDouble());
	}

	public double calcolaPerimetro(){
		return raggio*3.14*2;
	}

	public double calcolaArea(){
		return raggio*raggio*3.14;
	}

	public void print(PrintStream ps){
		ps.println("Cerchio di raggio: "+raggio);
	}
	
	private double raggio;
}
