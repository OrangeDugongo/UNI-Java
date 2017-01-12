import java.util.Scanner;
import java.util.LinkedList;
import java.io.PrintStream;
import java.util.function.Predicate;

public class Trivago{

    public Trivago(Scanner sc){
        list=new LinkedList<Albergo>();

        Albergo a=Albergo.read(sc);
        while(a!=null){
            list.add(a);
            a=Albergo.read(sc);
        }
    }

    private Trivago(LinkedList<Albergo> newList){
        this.list=newList;
    }

    public void print(PrintStream ps){
        for(Albergo a: list){
            a.print(ps);
            ps.println("****");
        }
    }

    private Trivago filtro(Predicate<Albergo> p){
        LinkedList<Albergo> listFilter = new LinkedList<Albergo>();
        for(Albergo a: list)
            if(p.test(a))
                listFilter.add(a);

        return new Trivago(listFilter);
    }

    public Trivago filtroTV(){
        return filtro(new TVPredicate());
    }
    
    public Trivago filtroAria(){
        return filtro(new AriaPredicate());
    }

    public Trivago filtroFrigo(){
        return filtro(new FrigoPredicate());
    }

    public Trivago filtroInternet(){
        return filtro(new InternetPredicate());
    }

    public Trivago filtroMaggiore(double prezzo){
        return filtro(new MaggiorePredicate(prezzo));
    }

    public Trivago filtroMinore(double prezzo){
        return filtro(new MinorePredicate(prezzo));
    }

    public Trivago filtroNome(String nome){
        return filtro(new NomePredicate(nome));
    }



    private LinkedList<Albergo> list;
}

class TVPredicate implements Predicate<Albergo>{
    public boolean test(Albergo a){
        return a.hasTV();
    }
}

class AriaPredicate implements Predicate<Albergo>{
    public boolean test(Albergo a){
        return a.hasAria();
    }
}

class FrigoPredicate implements Predicate<Albergo>{
    public boolean test(Albergo a){
        return a.hasFrigo();
    }
}

class InternetPredicate implements Predicate<Albergo>{
    public boolean test(Albergo a){
        return a.hasInternet();
    }
}

class MaggiorePredicate implements Predicate<Albergo>{

    public MaggiorePredicate(double prezzo){
        this.prezzo=prezzo;
    }

    public boolean test(Albergo a){
        return a.getPrezzo()>=prezzo?true:false;
    }

    private double prezzo;
}

class MinorePredicate implements Predicate<Albergo>{

    public MinorePredicate(double prezzo){
        this.prezzo=prezzo;
    }

    public boolean test(Albergo a){
        return a.getPrezzo()<=prezzo?true:false;
    }

    private double prezzo;
}

class NomePredicate implements Predicate<Albergo>{
    public NomePredicate(String nome){
        this.nome=nome;
    }

    public boolean test(Albergo a){
        return a.getNome().equals(nome);
    }

    private String nome;
}