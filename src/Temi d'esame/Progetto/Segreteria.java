import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

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
            }
            catch(ProgettoNonTrovato e){
                System.err.println(e.getMessage());
            }
            p=Progetto.read(scP);
        }
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

    private ArrayList<Progetto> progetti;
    private ArrayList<Capoprogetto> capoprogetti;
}