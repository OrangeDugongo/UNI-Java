import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager{
	public Manager(Scanner sc) throws Exception{
		figure = new ArrayList<FiguraGeometrica>();
		FiguraGeometrica fg=read(sc);
		while(fg!=null){//Alla prima lettura nulla interrompe l'intero processo di lettura
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
		else //Qualsiasi cosa diversa da rettangolo e regolare viene letta come cerchio
			fg=Cerchio.read(sc);

		return fg;
	}

	public FiguraGeometrica getMax(String tipo){
		Confrontatore conf = null;
		if(tipo.equals("perimetro")) conf = new ConfrontoPerimetro();
		if(tipo.equals("area")) conf = new ConfrontoArea();

		FiguraGeometrica max = figure.get(0);

		for (int i = 1; i < figure.size(); i++)
			if (!conf.confronto(max, figure.get(i)))
				max = figure.get(i);
		
		return max;
	}

	public FiguraGeometrica getMin(String tipo){
		Confrontatore conf = null;
		if(tipo.equals("perimetro")) conf = new ConfrontoPerimetro();
		if(tipo.equals("area")) conf = new ConfrontoArea();

		FiguraGeometrica max = figure.get(0);

		for (int i = 1; i < figure.size(); i++)
			if (conf.confronto(max, figure.get(i)))
				max = figure.get(i);

		return max;
	}

	public void print(PrintStream ps){
		for(FiguraGeometrica fg: figure){
			if(fg instanceof FiguraRegolare) 
				ps.print("Regolare ");
			else if(fg instanceof Rettangolo)
				ps.print("Rettangolo ");
			else
				ps.print("Cerchio ");
			fg.print(ps);

		}
	}

	private ArrayList<FiguraGeometrica> figure;
}
