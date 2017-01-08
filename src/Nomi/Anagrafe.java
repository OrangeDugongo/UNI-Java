import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintStream;

public class Anagrafe{

    public Anagrafe(Scanner sc)throws Exception{
        registro = new ArrayList<Persona>();
        Persona p = Persona.read(sc);
        while(p!=null){
            registro.add(p);
            p=Persona.read(sc);
        }      
    }

    private Anagrafe(ArrayList<Persona> registro){
        this.registro=registro;
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

    private ArrayList<Persona> registro;

}