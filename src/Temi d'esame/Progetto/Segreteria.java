import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.io.PrintStream;

public class Segreteria{

    public Segreteria(Scanner scP, Scanner scCP){
        progetti = new ArrayList<Progetto>();
        capoprogetti = new ArrayList<Capoprogetto>();

        Capoprogetto cp=Capoprogetto.read(scCP);
        while(cp!=null){
            capoprogetti.add(cp);
            cp=Capoprogetto.read(scCP);
        }

        Progetto p=Progetto.read(scP);
        while(p!=null){
            try{
                cp=searchCapoprogetto(p.getMatricola());
                cp.addProgetto(p);
                p.setCapoprogetto(cp);
                progetti.add(p);
            }
            catch(ProgettoNonTrovato e){
                System.err.println(e.getMessage());
            }
            p=Progetto.read(scP);
        }
    }

    private Segreteria(ArrayList<Progetto> progetti, ArrayList<Capoprogetto> capoprogetti){
        this.progetti=progetti;
        this.capoprogetti=capoprogetti;
    }

    private Capoprogetto searchCapoprogetto(String matricola){
        Iterator<Capoprogetto> iter = capoprogetti.iterator();
        Capoprogetto cp=null;
        boolean trovato=false;
        while(iter.hasNext() && !trovato){
            cp=iter.next();
            if (cp.getMatricola().equals(matricola))
                trovato=true;
        }

        if(trovato)
            return cp;
        throw new ProgettoNonTrovato("Il capoprogetto: "+matricola+" non è stato trovato");
    }

    public Segreteria filtroImportoMaggiore(double importo){
        ArrayList<Progetto> progettiFilter=new ArrayList<Progetto>();
        ArrayList<Capoprogetto> capoprogettiFilter=new ArrayList<Capoprogetto>();
        for(Progetto p: progetti)
            if(p.getImporto()>importo){
                progettiFilter.add(p);
                capoprogettiFilter.add(p.getCapoprogetto());
            }
        return new Segreteria(progettiFilter, capoprogettiFilter);
    }

    public Segreteria filtroNomeCapo(String nome){
        ArrayList<Progetto> progettiFilter=new ArrayList<Progetto>();
        ArrayList<Capoprogetto> capoprogettiFilter=new ArrayList<Capoprogetto>();
        for(Capoprogetto cp: capoprogetti)
            if(cp.getNome().equals(nome)){
                progettiFilter.addAll(cp.getProgetti());
                capoprogettiFilter.add(cp);
            }
        return new Segreteria(progettiFilter, capoprogettiFilter);
    }

    public void printReportCapi(PrintStream ps){
        for(Capoprogetto cp: capoprogetti){
            ps.println(cp.toString());
            cp.printProgetti(ps);
            ps.println("*****");
        }
    }

    public void printReportProgetti(PrintStream ps){
        for(Progetto p: progetti){
            ps.println(p.toString());
            ps.println(" + "+p.getCapoprogetto().toString());
            ps.println("*****");
        }
    }

    private ArrayList<Progetto> progetti;
    private ArrayList<Capoprogetto> capoprogetti;
}