import java.util.Scanner;
import java.io.*;

public class Test{
    public static void main(String [] args) throws Exception{
        Scanner sc = new Scanner(new File("matrici.dat"));
        Matrice m = Matrice.read(sc);
        Matrice m2 = Matrice.read(sc);
        Matrice m3;

        m3=m.transposed();

        System.out.print("Le matrici m e m3 sono: ");
        if(m.equals(m3))
            System.out.println("Uguali\n");
        else
            System.out.println("Diverse\n");

        System.out.println("Somma tra m2 e m3");
        m2.sum(m3).print(System.out);

        System.out.println("Prodotto tra m e m2");
        m.product(m2).print(System.out);
    }
}
