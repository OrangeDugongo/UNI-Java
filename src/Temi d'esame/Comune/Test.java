import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test{
    public static void main(String [] args){
        Scanner scC=null, scP=null;
        try{
            scC=new Scanner(new File("Cittadini.txt"));
            scP=new Scanner(new File("RelFam.txt"));
        }catch(FileNotFoundException e){
            System.exit(1);
        }
        Gestore g=new Gestore(scC, scP);

        g.print(System.out);
    }
}