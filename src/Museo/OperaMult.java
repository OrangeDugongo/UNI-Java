import java.util.Scanner;
import java.io.PrintStream;

public class OperaMult extends Opera{
    
    public OperaMult(String autore, String titolo, String supporto, int anno, String pos){
        super(autore, titolo, anno, pos);
        this.supporto=supporto;
    }

    public String getSupporto(){
        return supporto;
    }

    public int hashCode(){
        return super.hashCode()*supporto.hashCode();
    }

    public void print(PrintStream ps){
        ps.println("OM "+autore+" "+titolo+" "+supporto+" "+anno+" "+pos+".");
    }

    public static OperaMult read(Scanner sc){
        String autore, titolo, pos, supporto;
        int anno;

        if(!sc.hasNextLine()) return null;
        autore=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        titolo=sc.nextLine();
        if(!sc.hasNextLine()) return null;
        supporto=sc.nextLine();
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

        return new OperaMult(autore, titolo, supporto, anno, pos);
    }

    private String supporto;
}