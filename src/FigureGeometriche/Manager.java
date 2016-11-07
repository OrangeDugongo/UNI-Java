import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager{
	public Manager(Scanner sc) throws Exception{
		figure = new ArrayList<FiguraGeometrica>();
		FiguraGeometrica fg=read(sc);
		while(fg!=null){
			figure.add(fg);
			fg=read(sc);
		}
	}

	private static FiguraGeometrica read(Scanner sc)  throws Exception{
		FiguraGeometrica fg;
		String tipo;
		if(!sc.hasNext()) return null;
		tipo=sc.next();
		if(tipo.equals("Regolare"))
			fg=FiguraRegolare.read(sc);
		else if(tipo.equals("Rettangolo"))
			fg=Rettangolo.read(sc);
		else
			fg=Cerchio.read(sc);

		return fg;
	}
	
	public FiguraGeometrica getAreaMax() {
		FiguraGeometrica max = figure.get(0);

		for (int i = 1; i < figure.size(); i++)
			if (max.calcolaArea() < figure.get(i).calcolaArea())
				max = figure.get(i);
		
		return max;
	}

	public FiguraGeometrica getAreaMin() {
		FiguraGeometrica min = figure.get(0);

		for (int i = 1; i < figure.size(); i++)
			if (min.calcolaArea() > figure.get(i).calcolaArea())
				min = figure.get(i);
		
		return min;
	}
	
	public FiguraGeometrica getPerimetroMax(){
		FiguraGeometrica max = figure.get(0);

		for (int i = 1; i < figure.size(); i++)
			if (max.calcolaPerimetro() < figure.get(i).calcolaPerimetro())
				max = figure.get(i);
		
		return max;
	}

	public FiguraGeometrica getPerimetroMin(){
		FiguraGeometrica min = figure.get(0);

		for (int i = 1; i < figure.size(); i++)
			if (min.calcolaPerimetro() > figure.get(i).calcolaPerimetro())
				min = figure.get(i);

		return min;
	}
	
	public void print(PrintStream ps){
		for(FiguraGeometrica fg: figure)
			fg.print(ps);
	}

	private ArrayList<FiguraGeometrica> figure;
}
