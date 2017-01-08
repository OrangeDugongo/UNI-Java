import java.util.*;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

public class Persona{
    private String nome;
    private String cognome;
    private Date dataDiNascita;

    public Persona(String nome, String cognome, Date dataDiNascita){
        this.nome= nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
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

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDataDiNascita(Date dataDiNascita){
        this.dataDiNascita = dataDiNascita;
    }

    public void setCognome (String cognome){
        this.cognome = cognome;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return nome+" "+cognome+" "+sdf.format(dataDiNascita);
    }

    public void print(PrintStream ps){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ps.println(nome);
        ps.println(cognome);
        ps.println(sdf.format(dataDiNascita));

    }

    public static Persona read(Scanner sc) throws Exception{
        String nome, cognome;
        Date dataDiNascita;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if(!sc.hasNextLine()) return null;
        nome=sc.nextLine();
        if(!sc.hasNextLine())
        return null;
        cognome=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        dataDiNascita = sdf.parse(sc.nextLine());

        return new Persona(nome, cognome, dataDiNascita);
    }

}
