import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;

public class Test {
	public static void main(String [] args) throws Exception{
		Scanner sc = new Scanner(new File("figure"));
		Manager manager = new Manager(sc);
		PrintStream ps = System.out;
		
		ps.println("Figura con area maggiore");
		ps.println(manager.getMax("area").toString());
		
		ps.println("Figura con perimetro minore");
		ps.println(manager.getMin("perimetro").toString());
	}
}
