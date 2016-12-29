import java.util.Scanner;
import java.io.PrintStream;

public class Stampa extends Opera{
    
    public Stampa(String autore, String titolo, String tecnica, int anno, String pos){
        super(autore, titolo, anno, pos);
        this.tecnica=tecnica;
    }

    public int hashCode(){
        return super.hashCode()*tecnica.hashCode();
    }

    public void print(PrintStream ps){
        ps.println("S "+autore+" "+titolo+" "+tecnica+" "+anno+" "+pos+".");
    }

    public static Stampa read(Scanner sc){
        String autore, titolo, pos, tecnica;
        int anno;

        if(!sc.hasNextLine()) return null;
        autore=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        titolo=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        tecnica=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        anno=Integer.parseInt(sc.nextLine());
        if(!sc.hasNextLine()) return null;
        pos=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        sc.nextLine();

        return new Stampa(autore, titolo, tecnica, anno, pos);
    }

    private String tecnica;
}