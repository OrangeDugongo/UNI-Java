import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test{
    public static void main(String [] args){
        Scanner scCP=null, scP=null;
        try{
            scCP=new Scanner(new File("capi.dat"));
            scP=new Scanner(new File("progetti.dat"));
        }
        catch(FileNotFoundException e){
            System.err.println("Uno dei due file non esiste");
            System.exit(0);
        }
        Segreteria sg1 = new Segreteria(scP, scCP);
        sg1=sg1.filtroNomeCapo("Nome1");
        sg1.printReportCapi(System.out);
        System.out.println("-------------------");
        sg1.printReportProgetti(System.out);
    }
}