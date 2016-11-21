import java.util.Scanner;
import java.io.PrintStream;

public abstract class Dipendente{

    public Dipendente(String codiceFiscale, String nome, String cnome, double paga){

        this.codiceFiscale=codiceFiscale;
        this.nome=nome;
        this.cnome=cnome;
        this.paga=paga;
    }

    public abstract double calcoloPaga(int oreLavoro);
    //METODI GET

    public String getCodiceFiscale(){
        return codiceFiscale;
    }

    public String getNome(){
        return nome;
    }

    public String getCnome(){
        return cnome;
    }

    public double getPaga(){
        return paga;
    }




    //I/O

    public String toString(){
        return codiceFiscale+" "+nome+" "+cnome+" "+paga;
    }

    public abstract void print(PrintStream ps);

/* Non può essere utilizzata perché la classe è definita abstract
    public static Dipendente read(Scanner sc) throws Exception{
        String codiceFiscale, nome, cnome;
        double paga;

        if(!sc.hasNext()) return null;
        codiceFiscale=sc.next();
        if(!sc.hasNext()) return null;
        nome=sc.next();
        if(!sc.hasNext()) return null;
        cnome=sc.next();
        if(!sc.hasNextDouble()) return null;
        paga=sc.nextDouble();

        return new Dipendente(codiceFiscale, nome, cnome, paga);
    }
*/


    private String codiceFiscale;
    private String nome;
    private String cnome;
    private double paga;

}
