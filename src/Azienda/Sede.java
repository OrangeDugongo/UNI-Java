import java.io.PrintStream;
import java.util.Scanner;
import java.util.ArrayList;

public class Sede{

    public Sede(String id, String via, String comune, String stato){
        this.id=id;
        this.via=via;
        this.comune=comune;
        this.stato=stato;
        impiegati = new ArrayList<Impiegato>();
    }

    public String getId(){
        return id;
    }

    public String getVia(){
        return via;
    }

    public String getComune(){
        return comune;
    }

    public String getStato(){
        return stato;
    }

    public ArrayList<Impiegato> getImpiegati(){
        return impiegati;
    }

    public Sede copySede(ArrayList<Impiegato> impiegati){
        Sede sede = new Sede(getId(), getVia(), getComune(), getStato());
        sede.impiegati=impiegati;
        return sede;
    }

    public String toString(){
        return id + " " + via + " " + comune + " " + stato + ".";
    }

    public void print(PrintStream ps){
        ps.println(id);
        ps.println(via);
        ps.println(comune);
        ps.println(stato);
    }

    public static Sede read(Scanner sc){
        String id, via, comune, stato;

        if(!sc.hasNextLine()) return null;
        id=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        via=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        comune=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        stato=sc.nextLine();

        return new Sede(id, via, comune, stato);
    }

    private String id;
    private String via;
    private String comune;
    private String stato;
    private ArrayList<Impiegato> impiegati;
}
