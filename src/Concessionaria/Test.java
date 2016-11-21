import java.util.Scanner;
import java.io.File;

public class Test{

    public static void main(String [] args) throws Exception{
        Scanner scNuove = new Scanner(new File("nuove.dat"));
        Scanner scUsate = new Scanner(new File("usate.dat"));
        Concessionaria con = new Concessionaria(scNuove, scUsate);
        con.filtroAnnoImmatricolazione(2015).print(System.out);
    }
}