import java.io.PrintStream;
import java.util.Scanner;

public class Operaio extends Dipendente{

    public Operaio(String codiceFiscale, String nome, String cnome, double paga, String funzione, String livello){
        super(codiceFiscale, nome, cnome, paga);
        this.funzione=funzione;
        this.livello=livello;
    }

    public void print(PrintStream ps){
        ps.print(getCodiceFiscale()+" ");
        ps.print(getNome()+" ");
        ps.print(getCnome()+" ");
        ps.print(funzione+" ");
        ps.print(livello+" ");
        ps.println(getPaga());
    }

    public String toString(){
        return super.toString()+" "+funzione+" "+livello;
    }

    public double calcoloPaga(int oreLavoro){
        if(oreLavoro>165)
            return ((oreLavoro-165)*0.3+165)*super.getPaga();
        else
            return oreLavoro*getPaga();
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

    public String getLivello(){
        return livello;
    }

    public String getFunzione(){
        return funzione;
    }

    private String livello;
    private String funzione;
}