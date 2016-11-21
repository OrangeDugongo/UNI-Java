import java.util.Scanner;

public class AutoUsata extends Auto{

    public AutoUsata(String costruttore, String modello, String colore, String cilindrata, double prezzo, int annoImmatricolazione, String codiceProprietario){
        super(costruttore, modello, colore, cilindrata, prezzo);
        this.annoImmatricolazione=annoImmatricolazione;
        this.codiceProprietario=codiceProprietario;
    }

    public int getAnnoImmatricolazione(){
        return annoImmatricolazione;
    }

    public String getCodiceProprietario(){
        return codiceProprietario;
    }

    public double getPrezzoFinale(){
        return super.getPrezzo();
    }

    public static AutoUsata read(Scanner sc) throws Exception{
        String costruttore, modello, colore, cilindrata, codiceProprietario;
        double prezzo;
        int annoImmatricolazione;

        if(!sc.hasNext()) return null;
        costruttore=sc.next();
        if(!sc.hasNext()) return null;
        modello=sc.next();
        if(!sc.hasNext()) return null;
        colore=sc.next();
        if(!sc.hasNext()) return null;
        cilindrata=sc.next();
        if(!sc.hasNextDouble()) return null;
        prezzo=sc.nextDouble();
        if(!sc.hasNextInt()) return null;
        annoImmatricolazione=sc.nextInt();
        if(!sc.hasNext()) return null;
        codiceProprietario=sc.next();

        return new AutoUsata(costruttore, modello, colore, cilindrata, prezzo, annoImmatricolazione, codiceProprietario);
    }

    private int annoImmatricolazione;
    private String codiceProprietario;
}