import java.util.Scanner;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.IOException;

public class Azienda{

    public Azienda(Scanner scDipendenti) throws Exception{
        dipendenti = new ArrayList<Dipendente>();
        Dipendente dip=read(scDipendenti);
        while(dip!=null){
            dipendenti.add(dip);
            dip=read(scDipendenti);
        }
    }

    private Azienda(ArrayList<Dipendente> dipendenti){
        this.dipendenti=dipendenti;
    }

    private Dipendente read(Scanner sc) throws Exception{
        String id;

        if(!sc.hasNext()) return null;
        id=sc.next();
        if(id.equals("OP"))
            return Operaio.read(sc);
        else if(id.equals("DIR"))
            return Dirigente.read(sc);
        else{
            sc.nextLine();
            return read(sc);
        }
    }

    public void calcolaPrint(Scanner scPresenze, PrintStream ps) throws Exception{
        Dipendente dip;
        Presenze pres = Presenze.read(scPresenze);
        
        while(pres!=null){
            dip=ricercaDipendentePerCodice(pres.getCodiceFiscale());
            if(dip!=null){
                try{
                    double paga=dip.calcoloPaga(pres.getOreLavoro());
                    if(paga<=0) throw new IOException("Dipendente lavativo");
                    dip.print(ps);
                    ps.println("paga mensile: "+paga);
                }
                catch(IOException Exception){
                    System.err.println("Il dipendente "+dip.getNome()+" "+dip.getCnome()+" non ha svolto il suo lavoro");
                }
            }
            pres=Presenze.read(scPresenze);
        }
    }

    public Dipendente ricercaDipendentePerCodice(String codiceFiscale){
        boolean trovato=false;
        int i=0;
        while(i<dipendenti.size() && !trovato){
            if(dipendenti.get(i).getCodiceFiscale().equals(codiceFiscale)){
                trovato=true;
            }else
                i++;

        }
        if(trovato)
            return dipendenti.get(i);
        return null;
    }

    public Azienda filtroCnome(String cnome){
        ArrayList<Dipendente> dipendentiFilter = new ArrayList<Dipendente>();

        for(Dipendente dip: this.dipendenti)
            if(dip.getCnome().equals(cnome))
                dipendentiFilter.add(dip);
        
        return new Azienda(dipendentiFilter);
    }

     public Azienda filtroOP(){
        ArrayList<Dipendente> dipendentiFilter = new ArrayList<Dipendente>();

        for(Dipendente dip: this.dipendenti)
            if(dip instanceof Operaio)
                dipendentiFilter.add(dip);
        
        return new Azienda(dipendentiFilter);
    }

    public void print(PrintStream ps){
        for(Dipendente dip: dipendenti)
            dip.print(ps);
    }

    private ArrayList<Dipendente> dipendenti;
}