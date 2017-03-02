import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.PrintStream;

public class Store {

    public Store(Scanner scM, Scanner scP, Scanner scG){
        giacenze=new LinkedList<Giacenza>();
        prodotti=new LinkedList<Prodotto>();
        magazzini=new LinkedList<Magazzino>();

        Magazzino m=Magazzino.read(scM);
        while(m!=null){
            magazzini.add(m);
            m=Magazzino.read(scM);
        }
        
        Prodotto p=Prodotto.read(scP);
        while(p!=null){
            prodotti.add(p);
            p=Prodotto.read(scP);
        }

        Giacenza g=Giacenza.read(scG);
        while(g!=null){
            try{
                m=searchMagazzino(g.getCodeM());
            }
            catch(MagazzinoNonTrovato e){
                System.err.println(e.getMessage());
                System.err.println("Impostato a default.");
                m=new Magazzino();
            }
            try{
                p=searchProdotto(g.getCodeP());
                g.setMagazzino(m);
                g.setProdotto(p);
                p.addGiacenza(g);
                p.addMagazzino(m);
                m.addGiacenza(g);
                m.addProdotto(p);
                giacenze.add(g);
            }
            catch(ProdottoNonTrovato e){
                System.err.println(e.getMessage());
                System.err.println("Giacenza saltata");
            }
            g=Giacenza.read(scG);
        }
    }

    private Store(LinkedList<Magazzino> magazzini, LinkedList<Prodotto> prodotti, LinkedList<Giacenza> giacenze){
        this.magazzini=magazzini;
        this.prodotti=prodotti;
        this.giacenze=giacenze;
    }

    private Magazzino searchMagazzino(String codeM){
        boolean trovato=false;
        ListIterator<Magazzino> iter = magazzini.listIterator();
        Magazzino m=null;
        while(iter.hasNext() && !trovato){
            m=iter.next();
            if(m.getCodeM().equals(codeM))
                trovato=true;
        }

        if(trovato)
            return m;
        throw new MagazzinoNonTrovato("Il Magazzino con codice: "+codeM+" non è stato trovato");
    }

     private Prodotto searchProdotto(String codeP){
        boolean trovato=false;
        ListIterator<Prodotto> iter = prodotti.listIterator();
        Prodotto p=null;
        while(iter.hasNext() && !trovato){
            p=iter.next();
            if(p.getCodeP().equals(codeP))
                trovato=true;
        }

        if(trovato)
            return p;
        throw new ProdottoNonTrovato("Il Prodotto con codice: "+codeP+" non è stato trovato");
    }

    public Store filtroPrezzoMaggiore(double prezzo){
        LinkedList<Giacenza> giacenzeFilter=new LinkedList<Giacenza>();
        LinkedList<Prodotto> prodottiFilter=new LinkedList<Prodotto>();
        LinkedList<Magazzino> magazziniFilter=new LinkedList<Magazzino>();

        for(Prodotto p: prodotti)
            if(p.getPrezzo()>prezzo){
                prodottiFilter.add(p);
                giacenzeFilter.addAll(p.getGiacenze());
                magazziniFilter.addAll(p.getMagazzini());
            }
        return new Store(magazziniFilter, prodottiFilter, giacenzeFilter);
    }

    public void printReportProdotti(PrintStream ps){
        for(Prodotto p: prodotti){
            ps.println("Descrizione: "+p.getDescrizione()+"   Prezzo: "+p.getPrezzo());
            for(Giacenza g: p.getGiacenze())
                ps.println(g.getMagazzino().toString()+" "+g.getQuantità());
            ps.println("*****");
        }
    }


    private LinkedList<Giacenza> giacenze;
    private LinkedList<Prodotto> prodotti;
    private LinkedList<Magazzino> magazzini;
}
