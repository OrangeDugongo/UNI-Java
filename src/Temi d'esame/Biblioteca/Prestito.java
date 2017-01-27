import java.util.Date;
import java.util.Scanner;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Prestito{

    public Prestito(String nome, String cnome, String id, Date start, Date end){
        this.nome=nome;
        this.cnome=cnome;
        this.id=id;
        this.start=start;
        this.end=end;
        this.libro=null;
    }

    public String getNome(){
        return nome;
    }

    public String getCnome(){
        return cnome;
    }

    public String getID(){
        return id;
    }

    public Date getStart(){
        return start;
    }

    public Date getEnd(){
        return end;
    }

    public Libro getLibro(){
        return libro;
    }

    public void setEnd(Date end){
        this.end=end;
    }

    public void setLibro(Libro libro){
        this.libro=libro;
    }

    public static Prestito read(Scanner sc){

        String nome, cnome, id;
        Date start, end;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        if(!sc.hasNextLine()) return null;
		nome=sc.nextLine();
		if(!sc.hasNextLine()) return null;
		cnome=sc.nextLine();
		if(!sc.hasNextLine()) return null;
        id=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        try{
            start=sdf.parse(sc.nextLine());
        }
        catch(ParseException exception){
            start=new Date(0);
        }
		if(!sc.hasNextLine()) return null;
         try{
            end=sdf.parse(sc.nextLine());
        }
        catch(ParseException exception){
            end=new Date();
        }

        return new Prestito(nome, cnome, id, start, end);
    }

    public void print(PrintStream ps){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ps.println(nome);
        ps.println(cnome);
        ps.println(id);
        ps.println(sdf.format(start));
        ps.println(sdf.format(end));
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return nome+" "+cnome+" "+id+" "+sdf.format(start)+"-"+sdf.format(end);
    }

    private String nome;
    private String cnome;
    private String id;
    private Date start;
    private Date end;
    private Libro libro;
}