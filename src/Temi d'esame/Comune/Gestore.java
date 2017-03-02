import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintStream;
import java.util.Date;
import java.util.Iterator;

public class Gestore{

    public Gestore(Scanner scC, Scanner scR){
        ArrayList<Cittadino> cittadini=new ArrayList<Cittadino>();
        Cittadino c, famigliare;

        c=Cittadino.read(scC);
        while(c!=null){
            cittadini.add(c);
            c=Cittadino.read(scC);
        }

        Relazione r=Relazione.read(scR);
        while(r!=null){
            try{
                c=searchCittadino(r.getCodiceCapo());
                famigliare=searchCittadino(r.getCodiceFamigliare());
                c.addFamigliare(famigliare, r.getRelazione());
                if(r.getRelazione().equals("Figlio")) //Se sono padre figlio va cambiato il tipo di parentela
                    famigliare.addFamigliare(c, "Padre");
                else //Se sono cognugi no
                    famigliare.addFamigliare(c, r.getRelazione());
            }
            catch(CittadinoNonTrovato e){
                System.err.println("Cittadino non trovato");
            }
            r=Relazione.read(scR);
        }
        
    }

    private Gestore(ArrayList<Cittadino> cittadini){
        this.cittadini=cittadini;
    }

    public Cittadino searchCittadino(String codice){
        Iterator<Cittadino> iter = cittadini.iterator();
        boolean trovato = false;
        Cittadino c=null;

        while(!trovato && iter.hasNext()){
            c=iter.next();
            if(c.getCodice().equals(codice))
                trovato=true;
        }

        if(trovato)
            return c;
        throw new CittadinoNonTrovato();
    }

    public void printStatoFamiglia(PrintStream ps, String codice){
        Cittadino c;
        try{
            c=searchCittadino(codice);
            ps.println(c.toString());
            c.printFamigliari(ps);
        }
        catch(CittadinoNonTrovato e){
                System.err.println("Cittadino non trovato");
        }

    }

    public void printStatoFamiglia(PrintStream ps){
        for(Cittadino c: cittadini){
            ps.println(c.toString());
            c.printFamigliari(ps);
        }
    }

    public Gestore filtroNome(String nome){
        ArrayList<Cittadino> cittadiniFilter=new ArrayList<Cittadino>();

        for(Cittadino c: cittadini){
            if(c.getNome().equals(nome))
                cittadiniFilter.add(c);
        }

        return new Gestore(cittadiniFilter);
    }

    public Gestore filtroDataSposati(Date data){
        ArrayList<Cittadino> cittadiniFilter=new ArrayList<Cittadino>();

        for(Cittadino c: cittadini){
            if(c.getDataNascita().before(data) && c.hasConiuge())
                cittadiniFilter.add(c);
        }

        return new Gestore(cittadiniFilter);
    }

    public void print(PrintStream ps){
        for(Cittadino c: cittadini)
            ps.println(c.toString());
    }

    private ArrayList<Cittadino> cittadini;
}