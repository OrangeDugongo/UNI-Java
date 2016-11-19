import java.util.Scanner;
import java.io.PrintStream;
import java.util.ArrayList;

public class Azienda{

    public Azienda(Scanner scDipendenti, Scanner scPresenze) throws Exception{
        ArrayList<Presenze> presenze = new ArrayList<Presenze>();
        dipendenti = new ArrayList<Dipendente>();

        Presenze pres=Presenze.read(scPresenze);
        while(pres!=null){
            presenze.add(pres);
            pres=Presenze.read(scPresenze);
        }

        Dipendente dip=read(scDipendenti);
        while(dip!=null){
            for(Presenze p: presenze)
                if(dip.getCodiceFiscale().equals(p.getCodiceFiscale())){
                    dip.setOreLavoro(p.getOreLavoro());
                    break;//non è molto ortodosso
                }
                     
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