import java.util.Scanner;
import java.io.PrintStream;

public class Dipendente{

    public Dipendente(String codiceFiscale, String nome, String cnome, double paga){

        this.codiceFiscale=codiceFiscale;
        this.nome=nome;
        this.cnome=cnome;
        this.paga=paga;
        this.oreLavoro=0;
    }

    public double calcoloPaga(){
        return oreLavoro*getPaga();
    }

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

    public int getOreLavoro(){
        return oreLavoro;
    }

    public void setOreLavoro(int ore){
        oreLavoro=ore;
    }



    //I/O

    public String toString(){
        return codiceFiscale+" "+nome+" "+cnome+" "+paga;
    }

    public void print(PrintStream ps){
        ps.println(codiceFiscale);
        ps.println(nome);
        ps.println(cnome);
        ps.println(paga);
    }

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


    private String codiceFiscale;
    private String nome;
    private String cnome;
    private double paga;
    private int oreLavoro;

}
