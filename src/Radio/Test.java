import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.File;

public class Test{
    public static void main(String [] args) throws Exception{
        Scanner sc = new Scanner(new File("lib.dat"));
        LibreriaCanzoni radio=new LibreriaCanzoni(sc);

        ListIterator<Canzone> iter = radio.filtroAutore("Green Day").getLib().listIterator();

        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
    }
}