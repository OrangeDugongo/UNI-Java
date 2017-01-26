import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test{
    public static void main(String [] args){
        Scanner scP=null, scL=null;
        try{
            scP = new Scanner(new File("prestiti.dat"));
            scL = new Scanner(new File("libri.dat"));
        }
        catch(FileNotFoundException e){
            System.err.println("Impossibile trovare uno dei due file");
            System.exit(1);
        }
        
        Biblioteca bl1 = new Biblioteca(scP, scL);
        bl1.printStoricoPrestiti(System.out);
    }
}