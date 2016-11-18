import java.io.PrintStream;
import java.util.Scanner;

public class Operaio extends Dipendente{

    public Operaio(String codiceFiscale, String nome, String cnome, double paga, String funzione, String livello){
        super(codiceFiscale, nome, cnome, paga);
        this.funzione=funzione;
        this.livello=livello;
    }

    public void print(PrintStream ps){
        super.print(ps);
        ps.println(funzione);
        ps.println(livello);
    }

    public String toString(){
        return super.toString()+" "+funzione+" "+livello;
    }

    public double calcoloPaga(){
        int oreLavoro=super.getOreLavoro();
        if(oreLavoro>165)
            return ((oreLavoro-165)*0.3+165)*super.getPaga();
        else
            return oreLavoro*super.getPaga();
    }

    public static Operaio read(Scanner sc) throws Exception{
        String nome, cnome, livello, funzione, codiceFiscale;
        double paga;

        if(!sc.hasNext()) return null;
        codiceFiscale=sc.next();
        if(!sc.hasNext()) return null;
        nome=sc.next();
        if(!sc.hasNext()) return null;
        cnome=sc.next();
        if(!sc.hasNext()) return null;
        funzione=sc.next();
        if(!sc.hasNext()) return null;
        livello=sc.next();
        if(!sc.hasNextDouble()) return null;
        paga=sc.nextDouble();

        return new Operaio(codiceFiscale, nome, cnome, paga, funzione, livello);
    }

    private String livello;
    private String funzione;
}