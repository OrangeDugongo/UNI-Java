import java.util.Scanner;
import java.io.PrintStream;
import java.util.ArrayList;

public class Azienda{

    public Azienda(Scanner scDipendenti, Scanner scOreLavoro) throws Exception{
        Dipendente dip=read(scDipendenti);
        ArrayList<OreLavoro> oreLavoro = new ArrayList<OreLavoro>();
        dipendenti = new ArrayList<Dipendente>();
        OreLavoro ol=OreLavoro.read(scOreLavoro);
        while(ol!=null){
            oreLavoro.add(ol);
            ol=OreLavoro.read(scOreLavoro);
        }
        while(dip!=null){
            for(OreLavoro ore: oreLavoro)
                if(dip.getCodiceFiscale().equals(ore.getCodiceFiscale()))
                    dip.setOreLavoro(ore.getOreLavoro());
                    
            dipendenti.add(dip);
            dip=read(scDipendenti);
        }
    }

    private Dipendente read(Scanner sc) throws Exception{
        String id;

        if(!sc.hasNext()) return null;
        id=sc.next();
        if(id.equals("OP"))
            return Operaio.read(sc);
        else
            return Dirigente.read(sc);
    }

    public void print(PrintStream ps){
        for(Dipendente dip: dipendenti)
            ps.println(dip.getCodiceFiscale()+" "+dip.getNome()+" "+dip.getCnome()+" "+dip.calcoloPaga());
    }

    private ArrayList<Dipendente> dipendenti;
}