import java.util.LinkedList;
import java.util.Scanner;

public class LibreriaCanzoni{

    public LibreriaCanzoni(Scanner sc){
        lib = new LinkedList<Canzone>();
        Canzone temp=Canzone.read(sc);
        while(temp!=null){
            lib.addLast(temp);
            temp=Canzone.read(sc);
        }
    }

    private LinkedList<Canzone> lib;    
}