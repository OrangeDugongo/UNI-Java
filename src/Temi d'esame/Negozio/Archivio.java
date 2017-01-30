import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintStream;

public class Archivio {
    public Archivio(Scanner scN, Scanner scR){
        negozi=new ArrayList<Negozio>();
        responsabili=new ArrayList<Responsabile>();
        Responsabile r=Responsabile.read(scR);
        while(r!=null){
            responsabili.add(r);
            r=Responsabile.read(scR);
        }
        Negozio n=Negozio.read(scN);
        while(n!=null){
            try{
                r=searchResponsabile(n.getMatricola());
                n.setResponsabile(r);
                r.addNegozio(n);
                negozi.add(n);
            }
            catch(ResponsabileNonTrovato e){
                System.err.println(e.getMessage());
            }
            n=Negozio.read(scN);
        }
    }

    private Responsabile searchResponsabile(String matricola){
        Iterator<Responsabile> iter = responsabili.iterator();
        Responsabile r=null;
        boolean trovato=false;
        while(iter.hasNext() && !trovato){
            r=iter.next();
            if(r.getMatricola().equals(matricola))
                trovato=true;
        }

        if(trovato)
            return r;
        throw new ResponsabileNonTrovato("Il responsabile con matricola. "+matricola+" non è stato trovato");
    }

    public void printReportResponsabili(PrintStream ps){
        for(Responsabile r: responsabili){
            ps.println(r.toString());
            r.printNegozi(ps);
            ps.println("*****");
        }
    }

    private ArrayList<Negozio> negozi;
    private ArrayList<Responsabile> responsabili;
}
