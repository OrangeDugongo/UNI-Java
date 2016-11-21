import java.util.Scanner;
import java.io.File;

public class Test{
    public static void main(String [] args) throws Exception{
        Scanner scDipendenti = new Scanner(new File("dipendenti.dat"));
        Scanner scOreLavoro = new Scanner(new File("presenze.dat"));
        Azienda azienda = new Azienda(scDipendenti);
        azienda.calcolaPrint(scOreLavoro, System.out);
        System.out.println("******");
        scOreLavoro = new Scanner(new File("presenze.dat"));
        Azienda az1= azienda.filtroOP();
        az1.calcolaPrint(scOreLavoro, System.out);
    }
}