import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Cittadino{

    public Cittadino(String codiceFiscale, String nome, String cnome, Date dataNascita){
        this.codiceFiscale=codiceFiscale;
        this.nome=nome;
        this.cnome=cnome;
        this.dataNascita=dataNascita;
        this.famiglia=null;
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

    public String toString(){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        return codiceFiscale+" "+nome+" "+cnome+" "+sdf.format(dataNascita);
    }

    private String codiceFiscale;
    private String nome;
    private String cnome;
    private Date dataNascita;
    private Famiglia famiglia;
}