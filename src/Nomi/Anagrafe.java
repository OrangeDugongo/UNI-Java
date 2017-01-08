import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;

public class Anagrafe{

    public Anagrafe(Scanner sc)throws Exception{
        Comparator<Persona> cmp=new PersonaComparator();
        registro = new TreeSet<Persona>(cmp);
        Persona p = Persona.read(sc);
        while(p!=null){
            registro.add(p);
            p=Persona.read(sc);
        }      
    }

    private Anagrafe(ArrayList<Persona> registro){
        //this.registro=registro;
    }

    public void print(PrintStream ps){
        for(Persona p: registro){
            p.print(ps);
        }
    }

    public Anagrafe filtroNome(String nome){
        ArrayList<Persona> ar = new ArrayList<Persona>();
        for(Persona p: registro){
            if(p.getNome().equals(nome))
                ar.add(p);
        }

        return new Anagrafe(ar);
    }

    public Anagrafe filtroCognome(String cognome){
        ArrayList<Persona> ar = new ArrayList<Persona>();
        for(Persona p: registro){
            if(p.getCognome(). equals(cognome))
                ar.add(p);
        }
        return new Anagrafe(ar);
        
    }

    private Set<Persona> registro;

}

class PersonaComparator implements Comparator<Persona>{
    public int compare(Persona p1, Persona p2){
        int cmp=p1.getDataDiNascita().compareTo(p2.getDataDiNascita());
        if(cmp==0){
            cmp=p1.getCognome().compareTo(p2.getCognome());
            if(cmp==0){
                cmp=p1.getNome().compareTo(p2.getNome());
            }
        }
        return cmp;
    }
}