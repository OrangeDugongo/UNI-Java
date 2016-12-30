import java.util.Scanner;
import java.io.File;

public class Test{
    public static void main(String [] args) throws Exception{
        Scanner scLibri=new Scanner(new File("Libri.dat"));
        Scanner scMult=new Scanner(new File("OpereMult.dat"));
        Scanner scStampe=new Scanner(new File("Stampe.dat"));

        Archivio arch=new Archivio(scMult, scLibri, scStampe);

        arch.filtroTitolo("Titolo1").print(System.out);

        System.out.println("****");

        arch.filtroAutore("Autore1").filtroPosizione("4D").print(System.out);

        System.out.println("****");

        arch.filtroTecnica("Pergamena").filtroAnno(1999).print(System.out);
    }
}