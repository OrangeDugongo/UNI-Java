import java.util.Scanner;
import java.io.PrintStream;

public class Libro extends Opera{

    public Libro(String autore, String titolo, int anno, String pos){
        super(autore, titolo, anno, pos);
    }

    public int hashCode(){
        return super.hashCode();
    }

    public void print(PrintStream ps){
        ps.println("L "+autore+" "+titolo+" "+anno+" "+pos+".");
    }

    public static Libro read(Scanner sc){
        String autore, titolo, pos;
        int anno;

        if(!sc.hasNextLine()) return null;
        autore=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        titolo=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        try{
            anno=Integer.parseInt(sc.nextLine());
        }
        catch(NumberFormatException exception){
            System.err.println("Anno non inserito correttamente.\nAnno impostato a zero");
            anno=0;
        }
        if(!sc.hasNextLine()) return null;
        pos=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        sc.nextLine();

        return new Libro(autore, titolo, anno, pos);
    }
}