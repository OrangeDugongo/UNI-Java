import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.File;

public class Azienda{

    public Azienda(String srcSedi, String srcImpiegati) throws Exception{
        sedi = new ArrayList<Sede>();
        ArrayList<Impiegato> impiegati = new ArrayList<Impiegato>();
        Scanner scSedi = new Scanner(new File(srcSedi));
        Scanner scImpiegati = new Scanner(new File(srcImpiegati));

        Impiegato i = Impiegato.read(scImpiegati);
        while(i!=null){
            impiegati.add(i);
            i = Impiegato.read(scImpiegati);
        }

        Sede s = Sede.read(scSedi);
        while(s!=null){
            for(Impiegato imp: impiegati){
                if(s.getId().equals(imp.getSedeId()))
                    s.getImpiegati().add(imp);
                imp=Impiegato.read(scImpiegati);
            }
            sedi.add(s);
            s=Sede.read(scSedi);
        }
    }

    private Azienda(ArrayList<Sede> sedi){
        this.sedi=sedi;
    }

    public void print(PrintStream ps){
        ps.println("*****");
        for(Sede s: sedi){
            ps.println("SEDE:");
            s.print(ps);
            ps.println("    IMPIEGATI:");
            for(Impiegato i: s.getImpiegati())
                ps.println("    *"+i.toString());
        }
    }

    public Azienda filtroSedeId(String id){
        boolean trovato = false;
        int j=0;
        ArrayList<Sede> sediFilter = new ArrayList<Sede>();

        while(j<sedi.size() && !trovato){
            if(sedi.get(j).getId().equals(id))
                trovato = true;
            j++;
        }

        if(!trovato) return null;

        sediFilter.add(sedi.get(j-1));
        return new Azienda(sediFilter);
    }

    public Azienda filtroNome(String nome){
        ArrayList<Sede> sediFilter = new ArrayList<Sede>();
        ArrayList<Impiegato> impiegatiFilter;
        boolean almenoUno;

        for(Sede s: sedi){
            almenoUno=false;
            impiegatiFilter=new ArrayList<Impiegato>();
            for(Impiegato i: s.getImpiegati()){
                if(i.getNome().equals(nome)){
                    impiegatiFilter.add(i);
                    almenoUno=true;
                }

            }
            if(almenoUno)
                sediFilter.add(s.copySede(impiegatiFilter));

        }
        return new Azienda(sediFilter);
    }

    private ArrayList<Sede> sedi;
}
