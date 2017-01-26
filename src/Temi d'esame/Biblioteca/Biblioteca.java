import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.PrintStream;

public class Biblioteca{

    public Biblioteca(Scanner scP, Scanner scL){
        prestiti=new ArrayList<Prestito>();
        libri= new ArrayList<Libro>();

        // Lettura libri
        Libro l=Libro.read(scL);
        while(l!=null){
            libri.add(l);
            l=Libro.read(scL);
        }

        // Lettura prestiti
        Prestito p=Prestito.read(scP);
        while(p!=null){
            try{
                l=libroSearch(p.getID()); // ricerca del libro
                p.setLibro(l); // se il libro esiste viene linkato al prestito
                l.addPrestito(p); // il prestito viene linkato al libro
                prestiti.add(p); // il orestito viene agginto alla lista dei prestiti       
            }
            // Cosa fare se il libro non esiste
            catch(BookNotFound e){
                System.err.println(e.getMessage());
                System.err.println("Prestito saltato");
            }
            p=Prestito.read(scP);
        }
    }

    private Libro libroSearch(String id){
        Iterator<Libro> iter = libri.iterator();
        boolean trovato=false;
        Libro l=null;
        while(iter.hasNext() && !trovato){
            l=iter.next();
            if(l.getID().equals(id))
                trovato=true;
        }

        if(trovato)
            return l;
        throw new BookNotFound("Il libro: "+id+" non è stato trovato");
    }

    public void printStoricoPrestiti(PrintStream ps){
        for(Libro l: libri){
            ps.println(l.toString());
            l.printPrestiti(ps);
            ps.println("*****");
        }
    }



    private ArrayList<Prestito> prestiti;
    private ArrayList<Libro> libri;
}