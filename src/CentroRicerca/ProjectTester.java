import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProjectTester {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Projects.txt"));
		Project project = null;
		
		String type = sc.nextLine();
		//type = sc.nextLine();
		
		while (type != null){
			try {
				if(!type.equals("Ricerca") && !type.equals("Industria")) {
					throw new IncorrectLabelException("Label is not \"Industria\" or \"Ricerca\"!");
				}
					
				if(type.equals("Ricerca")) {
					project = ResearchProject.read(sc);
				} else if(type.equals("Industria")) {
					project = IndustrialProject.read(sc);
				}
				
				if(project != null) {
					project.print(System.out);
				}
				
			}
			catch(IncorrectLabelException e) {
				System.err.println("An exception occurred while reading project label \"" + type + "\"");
				System.err.println(e.getMessage());
				System.err.println("All next line different from Industria or Ricerca will be skipped...");
			
				while(!type.equals("Ricerca") && !type.equals("Industria") && sc.hasNextLine()) {
					type = sc.nextLine();
				}
				if(!sc.hasNextLine()) {
					type = null;
				}
			}
		}
	}
}
