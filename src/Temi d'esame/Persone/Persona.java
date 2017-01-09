import java.util.Scanner;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Persona{

    public Persona(String nome, String cognome, Date dataDiNascita, double peso, double altezza){
        this.nome=nome;
        this.cognome=cognome;
        this.dataDiNascita=dataDiNascita;
        this.peso=peso;
        this.altezza=altezza;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public Date getDataDiNascita(){
        return dataDiNascita;
    }

    public double getPeso(){
        return peso;
    }

    public double getAltezza(){
        return altezza;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDataDiNascita(Date dataDiNascita){
        this.dataDiNascita = dataDiNascita;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public void setPeso(double peso){
        this.peso=peso;
    }

    public void setAltezza(double altezza){
        this.altezza=altezza;
    }

    public static Persona read(Scanner sc){
        String nome, cognome;
        Date dataDiNascita;
        double peso, altezza;
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

        if(!sc.hasNextLine()) return null;
        nome=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        cognome=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        try{
            dataDiNascita=sdf.parse(sc.nextLine());
        }
        catch(ParseException exception){
            System.err.println("Impossibile convertire la stringa in data");
            System.err.println("Data impostata a epoch");
            dataDiNascita=new Date(0);
        }
        if(!sc.hasNextLine()) return null;
        try{
            peso=Double.parseDouble(sc.nextLine());
        }
        catch(NumberFormatException exception){
            System.err.println("Impossibile convertire la stringa in data");
            System.err.println("Peso impostato a 0");
            peso=0;
        }
        if(!sc.hasNextLine()) return null;
        try{
            altezza=Double.parseDouble(sc.nextLine());
        }
        catch(NumberFormatException exception){
            System.err.println("Impossibile convertire la stringa in data");
            System.err.println("altezza impostata a 0");
            altezza=0;
        }

        return new Persona(nome, cognome, dataDiNascita, peso, altezza);
    }

    public void print(PrintStream ps){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        ps.println(nome);
        ps.println(cognome);
        ps.println(sdf.format(dataDiNascita));
        ps.println(peso);
        ps.println(altezza);
    }

    private String nome;
    private String cognome;
    private Date dataDiNascita;
    private double peso;
    private double altezza;
}