import java.io.PrintStream;
import java.util.Scanner;
import java.lang.RuntimeException;

public class Dirigente extends Dipendente{

    public Dirigente(String codiceFiscale, String nome, String cnome, double paga, String areaResponsabilità){
        super(codiceFiscale, nome, cnome, paga);
        this.areaResponsabilità=areaResponsabilità;
    }

    public void print(PrintStream ps){
        ps.print(getCodiceFiscale()+" ");
        ps.print(getNome()+" ");
        ps.print(getCnome()+" ");
        ps.print(areaResponsabilità+" ");
        ps.println(getPaga());
    }

    public static Dirigente read(Scanner sc) throws Exception{
        String nome, cnome, areaResponsabilità, codiceFiscale;
        double paga=0;
        if(!sc.hasNext()) return null;
        codiceFiscale=sc.next();
        if(!sc.hasNext()) return null;
        nome=sc.next();
        if(!sc.hasNext()) return null;
        cnome=sc.next();
        if(!sc.hasNext()) return null;
        areaResponsabilità=sc.next();
        if(!sc.hasNextDouble()) return null;
        try{
            paga=sc.nextDouble();
            if(paga<0) throw new RuntimeException("Paga minore di zero");
        }

        catch(RuntimeException Exception){
            System.err.println("***"+Exception.getMessage()+"***");
            System.err.println("Paga di "+nome+" "+cnome+" impostata come valore assoluto"); 
            paga=-paga;
        }

        return new Dirigente(codiceFiscale, nome, cnome, paga, areaResponsabilità);
    }

    public String getAreaResponsabilità(){
        return areaResponsabilità;
    }

    public double calcoloPaga(int oreLavoro){
         return oreLavoro*getPaga();
    }

    private String areaResponsabilità;
}