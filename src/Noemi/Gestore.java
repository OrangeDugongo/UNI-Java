public class Gestore{

    public Gestore filtroautore(String autore){
        for(Opera o: opere){
            if(o.getAutore().equals(autore))
                ADD
        }
    }

    public Gestore filtroautore(String autore){
        for(Opera o: opere){
            if(o instanceof Libro)
                Libro l=(Libro) o;
            if(l.getCasaEd().equals(autore))
                ADD
        }
    }

    private ArrayList<Opera> opere;
}