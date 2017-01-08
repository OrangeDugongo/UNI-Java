import java.io.PrintStream;
import java.util.Scanner;

public class mimmo {
    public static void main(String [] args){
        PrintStream ps =System.out;
        while(true){
            ps.println("Come ti chiami?");
            Scanner sc = new Scanner(System.in);
            String name=sc.next();
            if(name.equalsIgnoreCase("erica"))
                ps.println("Erica sei scema!!!");
            else if(name.equalsIgnoreCase("marco"))
                ps.println("Marco sei un figlio di puttana");
            else
                ps.println("Ciao, "+name);
        }
    }
}