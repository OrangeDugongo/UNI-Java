import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Predicate;
import java.io.PrintStream;

public class Archivio{

    public Archivio(Scanner scMult, Scanner scLibri, Scanner scStampe){
        archivio=new HashSet<Opera>();
 
        Opera op=Libro.read(scLibri);
        while(op!=null){
            archivio.add(op);
            op=Libro.read(scLibri);
        }

        op=OperaMult.read(scMult);
         while(op!=null){
            archivio.add(op);
            op=OperaMult.read(scMult);
        }

        op=Stampa.read(scStampe);
         while(op!=null){
            archivio.add(op);
            op=Stampa.read(scStampe);
        }
    }

    public Archivio(Set<Opera> archivio){
        this.archivio=archivio;
    }

    public void print(PrintStream ps){
        for(Opera o: archivio){
            o.print(ps);
        }
    }

    public Archivio filtroPosizione(String pos){
        return filtro(new PredicatePosizione(pos));
    }

    public Archivio filtroAutore(String autore){
        return filtro(new PredicateAutore(autore));
    }

    public Archivio filtroTitolo(String titolo){
        return filtro(new PredicateTitolo(titolo));
    }

    public Archivio filtroTecnica(String tecnica){
        return filtro(new PredicateTecnica(tecnica));
    }

    public Archivio filtroSupporto(String supporto){
        return filtro(new PredicateSupporto(supporto));
    }

    public Archivio filtroAnno(int anno){
        return filtro(new PredicateAnno(anno));
    }

    public Archivio filtro(Predicate<Opera> predicate){
        Set<Opera> archivioFilter = new HashSet<Opera>();
        for(Opera o: archivio)
            if(predicate.test(o))
                archivioFilter.add(o);

        return new Archivio(archivioFilter); 
    }


    //Predicate's class'

    class PredicateAutore implements Predicate<Opera>{
        public PredicateAutore(String autore){
            this.autore=autore;
        }

        public boolean test(Opera o){
            return o.getAutore().equals(autore);
        }

        private String autore;
    }

    class PredicateTitolo implements Predicate<Opera>{
        public PredicateTitolo(String titolo){
            this.titolo=titolo;
        }

        public boolean test(Opera o){
            return o.getTitolo().equals(titolo);
        }

        private String titolo;
    }

    class PredicateAnno implements Predicate<Opera>{
        public PredicateAnno(int anno){
            this.anno=anno;
        }

        public boolean test(Opera o){
            return o.getAnno()==anno;
        }

        private int anno;
    }

    class PredicateTecnica implements Predicate<Opera>{
        public PredicateTecnica(String tecnica){
            this.tecnica=tecnica;
        }

        public boolean test(Opera o){
            return o instanceof Stampa && ((Stampa) o).getTecnica().equals(tecnica);
        }

        private String tecnica;
    }

    class PredicateSupporto implements Predicate<Opera>{
        public PredicateSupporto(String supporto){
            this.supporto=supporto;
        }

        public boolean test(Opera o){
            return o instanceof OperaMult && ((OperaMult) o).getSupporto().equals(supporto);
        }

        private String supporto;
    }

    class PredicatePosizione implements Predicate<Opera>{
        public PredicatePosizione(String pos){
            this.pos=pos;
        }

        public boolean test(Opera o){
            return o.getPos().equals(pos);
        }

        private String pos;
    }
    
    private Set<Opera> archivio;
}