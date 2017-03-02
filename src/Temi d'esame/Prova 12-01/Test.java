import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test{
    public static void main(String [] args){
        Scanner scM=null, scP=null, scG=null;
        try{
            scM=new Scanner(new File("magazzini.dat"));
            scP=new Scanner(new File("prodotti.dat"));
            scG=new Scanner(new File("giacenze.dat"));
        }
        catch(FileNotFoundException e){
            System.err.println("Uno dei file non esiste");
            System.exit(1);
        }
        Store store=new Store(scM, scP, scG);
        store.filtroPrezzoMaggiore(15).printReportProdotti(System.out);
    }
}