import java.util.Scanner;

public class AutoNuova extends Auto{

    public AutoNuova(String costruttore, String modello, String colore, String cilindrata, double prezzo, int sconto){
        super(costruttore, modello, colore, cilindrata, prezzo);
        this.sconto=sconto;
    }

    public double getPrezzoFinale(){
        return super.getPrezzo()*(1-sconto/100);
    }

    public int getSconto(){
        return sconto;
    }

    public void setSconto(int newSconto){
        this.sconto=newSconto;
    }

    public static AutoNuova read(Scanner sc) throws Exception{
        String costruttore, modello, colore, cilindrata;
        double prezzo;
        int sconto;

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
        sconto=sc.nextInt();

        return new AutoNuova(costruttore, modello, colore, cilindrata, prezzo, sconto);
    }

    private int sconto;
}