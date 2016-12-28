import java.util.LinkedList;
import java.util.ListIterator;
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

    public LibreriaCanzoni(LinkedList<Canzone> lib){
        this.lib=lib;
    }

    public LibreriaCanzoni filtroAutore(String autore){
        LinkedList<Canzone> newLib = new LinkedList<Canzone>();
        ListIterator<Canzone> iter = lib.listIterator();
        while(iter.hasNext()){
            Canzone temp=iter.next();
            if(temp.getAutore().equals(autore))
                newLib.addLast(temp);
        }

        return new LibreriaCanzoni(newLib);
    }

      public LibreriaCanzoni filtroTitolo(String titolo){
        LinkedList<Canzone> newLib = new LinkedList<Canzone>();
        ListIterator<Canzone> iter = lib.listIterator();
        while(iter.hasNext()){
            Canzone temp=iter.next();
            if(temp.getAutore().equals(titolo))
                newLib.addLast(temp);
        }

        return new LibreriaCanzoni(newLib);
    }

      public LibreriaCanzoni filtroAlbum(String album){
        LinkedList<Canzone> newLib = new LinkedList<Canzone>();
        ListIterator<Canzone> iter = lib.listIterator();
        while(iter.hasNext()){
            Canzone temp=iter.next();
            if(temp.getAutore().equals(album))
                newLib.addLast(temp);
        }

        return new LibreriaCanzoni(newLib);
    }

    private LinkedList<Canzone> lib;    
}