import java.io.File;
import java.util.Scanner;

public class Test {
	public static void main(String [] args) throws Exception{
		Scanner sc = new Scanner(new File("figure"));
		Manager manager = new Manager(sc);
		
		manager.getAreaMax().print(System.out);
	}
}
