import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ResearchCenterTester {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Projects.txt"));
		ResearchCenter rc = new ResearchCenter(sc);

		rc.print(System.out);
		System.out.println("*****");
		
		rc.sortByName();
		rc.print(System.out);
	}

}
