import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Segreteria{

    public Segreteria(String srcEsami, String srcStudenti) throws Exception{
        esami = new ArrayList<Esame>();
        studenti = new ArrayList<Studente>();
        Esame e;
        Studente s;

        Scanner sc = new Scanner(new File(srcEsami));
        e=Esame.read(sc);
        while(e!=null){
            esami.add(e);
            e=Esame.read(sc);
        }

        sc = new Scanner(new File(srcStudenti));
        s=Studente.read(sc);
        while(s!=null){
            studenti.add(s);
            s=Studente.read(sc);
        }
    }

    private Segreteria(ArrayList<Esame> esami, ArrayList<Studente> studenti){
        this.esami=esami;
        this.studenti=studenti;
    }

    public void print(PrintStream ps){
        for(Studente s: studenti)
            s.print(ps);

        for(Esame e: esami)
            e.print(ps);
    }

    public Segreteria filtroMaggioreVoto(int voto){
        ArrayList<Esame> esami = new ArrayList<Esame>();
        ArrayList<Studente> studenti = new ArrayList<Studente>();

        for(Esame e: this.esami){
            if(e.getVoto()>=voto){
                esami.add(e);
                for(Studente s: this.studenti)
                    if(e.getMatricola()==s.getMatricola())
                        studenti.add(s);
            }

        }

        if(esami.size()==0) return null;
        return new Segreteria(esami, studenti);
    }

    public Segreteria filtroMinoreVoto(int voto){
        ArrayList<Esame> esami = new ArrayList<Esame>();
        ArrayList<Studente> studenti = new ArrayList<Studente>();

        for(Esame e: this.esami){
            if(e.getVoto()<voto){
                esami.add(e);
                for(Studente s: this.studenti)
                    if(e.getMatricola()==s.getMatricola())
                        studenti.add(s);
            }

        }

        if(esami.size()==0) return null;
        return new Segreteria(esami, studenti);
    }

    public Segreteria filtroMatricola(int matricola){
        ArrayList<Esame> esami = new ArrayList<Esame>();
        ArrayList<Studente> studenti = new ArrayList<Studente>();
        int i=0;
        boolean trovato=false;

        for(Esame e: this.esami){
            if(e.getMatricola()==matricola)
                esami.add(e);
        }

        while(i<this.studenti.size() && !trovato){
            if(this.studenti.get(i).getMatricola()==matricola){
                studenti.add(this.studenti.get(i));
                trovato=true;
            }
            i++;
        }

        if(!trovato) return null;
        return new Segreteria(esami, studenti);

    }

    public int getMatricola(String nome, String cnome){
        int i=0;
        boolean trovato=false;

        while(i<this.studenti.size() && !trovato){
            if(this.studenti.get(i).equals(nome, cnome))
                trovato=true;
            i++;
        }

        if(!trovato) return 0;
        return this.studenti.get(i-1).getMatricola();
    }

    private ArrayList<Esame> esami;
    private ArrayList<Studente> studenti;
}
