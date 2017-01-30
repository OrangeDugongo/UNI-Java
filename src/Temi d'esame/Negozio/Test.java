import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test{
    public static void main(String [] args){
        Scanner scN=null, scR=null;
        try{
            scN=new Scanner(new File("negozi.dat"));
            scR=new Scanner(new File("responsabili.dat"));
        }
        catch(FileNotFoundException e){
            System.err.println("uno dei due file non esiste.");
            System.exit(1);
        }
        Archivio ar1=new Archivio(scN, scR);
        ar1.printReportResponsabili(System.out);
    }
}