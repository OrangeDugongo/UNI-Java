import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintStream;

public class Concessionaria{

    public Concessionaria(Scanner scNuove, Scanner scUsate) throws Exception{
        auto = new ArrayList<Auto>();

        Auto a = AutoNuova.read(scNuove);
        while(a!=null){
            auto.add(a);
            a=AutoNuova.read(scNuove);
        }

        a=AutoUsata.read(scUsate);
        while(a!=null){
            auto.add(a);
            a=AutoUsata.read(scUsate);
        }
    }

    private Concessionaria(ArrayList<Auto> auto){
        this.auto=auto;
    }

    public void print(PrintStream ps){
        for(Auto a: auto){
            if(a instanceof AutoNuova)
                ps.print("Auto Nuova: ");
            else
                ps.print("Auto Usata: ");
            ps.println(a.toString());
        }
    }

    public Concessionaria filtroUsato(){
        ArrayList<Auto> autoFilter = new ArrayList<Auto>();
        for(Auto a: auto)
            if(a instanceof AutoUsata)
                autoFilter.add(a);
        return new Concessionaria(autoFilter);
    }

    public Concessionaria filtroNuovo(){
        ArrayList<Auto> autoFilter = new ArrayList<Auto>();
        for(Auto a: auto)
            if(a instanceof AutoNuova)
                autoFilter.add(a);
        return new Concessionaria(autoFilter);
    }

    public Concessionaria filtroPrezzoMinore(double prezzo){
        ArrayList<Auto> autoFilter = new ArrayList<Auto>();
        for(Auto a: auto)
            if(a.getPrezzoFinale()<prezzo)
                autoFilter.add(a);
        return new Concessionaria(autoFilter);
    }

     public Concessionaria filtroPrezzoMaggiore(double prezzo){
        ArrayList<Auto> autoFilter = new ArrayList<Auto>();
        for(Auto a: auto)
            if(a.getPrezzoFinale()>=prezzo)
                autoFilter.add(a);
        return new Concessionaria(autoFilter);
    }

    public Concessionaria filtroModello(String modello){
        ArrayList<Auto> autoFilter = new ArrayList<Auto>();
        for(Auto a: auto)
            if(a.getModello().equals(modello))
                autoFilter.add(a);
        return new Concessionaria(autoFilter);
    }

    public Concessionaria filtroCostruttore(String costruttore){
        ArrayList<Auto> autoFilter = new ArrayList<Auto>();
        for(Auto a: auto)
            if(a.getCostruttore().equals(costruttore))
                autoFilter.add(a);
        return new Concessionaria(autoFilter);
    }

    public Concessionaria filtroColore(String colore){
        ArrayList<Auto> autoFilter = new ArrayList<Auto>();
        for(Auto a: auto)
            if(a.getColore().equals(colore))
                autoFilter.add(a);
        return new Concessionaria(autoFilter);
    }

    public Concessionaria filtroProprietario(String codiceProprietario){
        ArrayList<Auto> autoFilter = new ArrayList<Auto>();
        for(Auto a: auto)
            if(a instanceof AutoUsata && ((AutoUsata) a).getCodiceProprietario().equals(codiceProprietario))
                autoFilter.add(a);
        return new Concessionaria(autoFilter);
    }

    public Concessionaria filtroAnnoImmatricolazione(int annoImmatricolazione){
        ArrayList<Auto> autoFilter = new ArrayList<Auto>();
        for(Auto a: auto)
            if(a instanceof AutoUsata && ((AutoUsata) a).getAnnoImmatricolazione()==annoImmatricolazione)
                autoFilter.add(a);
        return new Concessionaria(autoFilter);
    }


    private ArrayList<Auto> auto;
}