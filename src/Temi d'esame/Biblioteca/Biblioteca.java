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
                l=libroSearchByID(p.getID()); // ricerca del libro
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

    public Biblioteca(ArrayList<Libro> libri, ArrayList<Prestito> prestiti){
        this.prestiti=prestiti;
        this.libri=libri;
    }

    private Libro libroSearchByID(String id){
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

    public void printStricoUtente(PrintStream ps){
        for(Prestito p: prestiti){
            ps.print(p.toString()+" ");
            ps.println(p.getLibro().toString());
        }
    }

    public Biblioteca filtroLibroByID(String id){
        ArrayList<Prestito> prestitiFilter=new ArrayList<Prestito>();
        ArrayList<Libro> libriFilter= new ArrayList<Libro>();
        Libro l=libroSearchByID(id);
        libriFilter.add(l);
        prestitiFilter.addAll(l.getPrestiti());
        return new Biblioteca(libriFilter, prestitiFilter);
    }

    public Biblioteca filtroLibroByTitolo(String titolo){
        ArrayList<Prestito> prestitiFilter=new ArrayList<Prestito>();
        ArrayList<Libro> libriFilter= new ArrayList<Libro>();
        for(Libro l: libri)
            if(l.getTitolo().equals(titolo)){
                libriFilter.add(l);
                prestitiFilter.addAll(l.getPrestiti());
            }
        return new Biblioteca(libriFilter, prestitiFilter);
    }

    public Biblioteca filtroLibroByAutore(String autore){
        ArrayList<Prestito> prestitiFilter=new ArrayList<Prestito>();
        ArrayList<Libro> libriFilter= new ArrayList<Libro>();
        for(Libro l: libri)
            if(l.hasAutore(autore)){
                libriFilter.add(l);
                prestitiFilter.addAll(l.getPrestiti());
            }
        return new Biblioteca(libriFilter, prestitiFilter);
    }

    public Biblioteca filtroPrestitoByNome(String nome){
        ArrayList<Prestito> prestitiFilter=new ArrayList<Prestito>();
        ArrayList<Libro> libriFilter= new ArrayList<Libro>();
        for(Prestito p: prestiti)
            if(p.getNome().equals(nome)){
                libriFilter.add(p.getLibro());
                prestitiFilter.add(p);
            }
        return new Biblioteca(libriFilter, prestitiFilter);
    }



    private ArrayList<Prestito> prestiti;
    private ArrayList<Libro> libri;
}