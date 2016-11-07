import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager{
	public Manager(Scanner sc) throws Exception{
		figure = new ArrayList<FiguraGeometrica>();
		FiguraGeometrica fg;
		String tipo=sc.next();
		
		do{
			if(!sc.hasNext()) 
				fg=null;
			else{
				tipo=sc.next();
				if(tipo.equals("Regolare"))
					fg=FiguraRegolare.read(sc);
				else if(tipo.equals("Rettangolo"))
					fg=Rettangolo.read(sc);
				else
					fg=Cerchio.read(sc);
			figure.add(fg);
			}
		}while(fg!=null);
	}
	
	public double getAreaMax() {
		FiguraGeometrica max = figure.get(0);

		for (int i = 1; i < figure.size(); i++)
			if (max.calcolaArea() < figure.get(i).calcolaArea())
				max = figure.get(i);
		
		return max.calcolaArea();
	}
	
	public void print(PrintStream ps){
		for(FiguraGeometrica fg: figure)
			fg.print(ps);
	}

	private ArrayList<FiguraGeometrica> figure;
}
