import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;

public class Test {
	public static void main(String [] args) throws Exception{
		Scanner sc = new Scanner(new File("figure"));
		Manager manager = new Manager(sc);
		PrintStream ps = System.out;
		
		ps.println("Figura con area maggiore");
		manager.getMax("area").print(ps);
		ps.println("Figura con perimetro minore");
		manager.getMin("perimetro").print(ps);
	}
}
