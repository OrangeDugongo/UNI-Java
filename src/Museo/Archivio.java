import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintStream;

public class Archivio{

    public Archivio(Scanner scMult, Scanner scLibri, Scanner scStampe){
        archivio=new HashSet<Opera>();
 
        Opera op=Libro.read(scLibri);
        while(op!=null){
            archivio.add(op);
            op=Libro.read(scLibri);
        }

        op=OperaMult.read(scMult);
         while(op!=null){
            archivio.add(op);
            op=OperaMult.read(scMult);
        }

        op=Stampa.read(scStampe);
         while(op!=null){
            archivio.add(op);
            op=Stampa.read(scStampe);
        }
    }

    public Archivio(Set<Opera> archivio){
        this.archivio=archivio;
    }

    public void print(PrintStream ps){
        for(Opera o: archivio){
            o.print(ps);
        }
    }

    public Archivio filtroStringa(FiltroStringa fs, String stringa){
        Set<Opera> nuovoSet = new HashSet<Opera>();
        for(Opera o: archivio)
            if(fs.getString(o).equals(stringa))
                nuovoSet.add(o);

        return new Archivio(nuovoSet); 
    }

    public Archivio filtroPosizione(String stringa){
        return filtroStringa(new FiltroPosizione(), stringa);
    }

    public Archivio filtroAnno(int anno){
        Set<Opera> nuovoSet = new HashSet<Opera>();
        for(Opera o: archivio)
            if(o.getAnno()==anno)
                nuovoSet.add(o);

        return new Archivio(nuovoSet); 
    }
    
    private Set<Opera> archivio;
}