import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.PrintStream;

public class Cittadino{

    public Cittadino(String codiceFiscale, String nome, String cnome, Date dataNascita){
        this.codiceFiscale=codiceFiscale;
        this.nome=nome;
        this.cnome=cnome;
        this.dataNascita=dataNascita;
        this.famiglia=new ArrayList<Parentela>();
    }

    public static Cittadino read(Scanner sc){
        String codiceFiscale, nome, cnome;
        Date dataNascita;
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

        if(!sc.hasNextLine()) return null;
        codiceFiscale=sc.nextLine();

        if(!sc.hasNextLine()) return null;
        nome=sc.nextLine();

        if(!sc.hasNextLine()) return null;
        cnome=sc.nextLine();

        if(!sc.hasNextLine()) return null;
        try{
            dataNascita=sdf.parse(sc.nextLine());
        }
        catch(ParseException e){
            System.err.println("Data non inserita correttamente.");
            dataNascita=new Date(0);
        }

        return new Cittadino(codiceFiscale, nome, cnome, dataNascita);
    }

    public String getNome(){
        return nome;
    }

    public String getCodice(){
        return codiceFiscale;
    }

    public Date getDataNascita(){
        return dataNascita;
    }

    public void addFamigliare(Cittadino c, String parentela){
        Parentela p=new Parentela(c, parentela);
        famiglia.add(p);
    }

    public String toString(){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        return codiceFiscale+" "+nome+" "+cnome+" "+sdf.format(dataNascita);
    }

    public void printFamigliari(PrintStream ps){
        for(Parentela p: famiglia)
            ps.println(p.toString());
    }

    public boolean hasConiuge(){
        for(Parentela p: famiglia)
            if(p.getRelazione().equals("coniuge"))
                return true;

        return false;
    }

    private String codiceFiscale;
    private String nome;
    private String cnome;
    private Date dataNascita;
    private ArrayList<Parentela> famiglia;
}