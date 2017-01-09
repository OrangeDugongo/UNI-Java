import java.util.Comparator;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
import java.io.PrintStream;

public class AlberoBinarioDiRicerca{

    public AlberoBinarioDiRicerca(Scanner sc, Comparator<Persona> cmp){
        tree = new TreeSet<Persona>(cmp);
        Persona p=Persona.read(sc);
        while(p!=null){
            tree.add(p);
            p=Persona.read(sc);
        }
    }

    private AlberoBinarioDiRicerca(Set<Persona> tree){
        this.tree=tree;
    }

    public AlberoBinarioDiRicerca sort(Comparator<Persona> cmp){
        Set<Persona> newTree = new TreeSet<Persona>(cmp);
        for(Persona p: tree)
            newTree.add(p);
        return new AlberoBinarioDiRicerca(newTree);
    }

    public void print(PrintStream ps){
        for(Persona p: tree)
            p.print(ps);
    }

    private Set<Persona> tree;
}

class NomeComparator implements Comparator<Persona>{
    public int compare(Persona p1, Persona p2){
        return p1.getNome().compareTo(p2.getNome());
    }
}

class CognomeComparator implements Comparator<Persona>{
    public int compare(Persona p1, Persona p2){
        return p1.getCognome().compareTo(p2.getCognome());
    }
}

class DataComparator implements Comparator<Persona>{
    public int compare(Persona p1, Persona p2){
        return p1.getDataDiNascita().compareTo(p2.getDataDiNascita());
    }
}

class PesoComparator implements Comparator<Persona>{
    public int compare(Persona p1, Persona p2){
        return ((Double) p1.getPeso()).compareTo((Double) (p2.getPeso()));
    }
}

class AltezzaComparator implements Comparator<Persona>{
    public int compare(Persona p1, Persona p2){
        return ((Double) p1.getAltezza()).compareTo((Double) (p2.getAltezza()));
    }
}