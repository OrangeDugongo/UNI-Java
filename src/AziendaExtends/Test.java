import java.util.Scanner;
import java.io.File;

public class Test{
    public static void main(String [] args) throws Exception{
        Scanner scDipendenti = new Scanner(new File("Dipendenti"));
        Scanner scOreLavoro = new Scanner(new File("OreLavoro"));
        Azienda azienda = new Azienda(scDipendenti, scOreLavoro);
        azienda.print(System.out);
    }
}