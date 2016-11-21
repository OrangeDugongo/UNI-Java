import java.util.Scanner;

public class Auto{

    public Auto(String costruttore, String modello, String colore, String cilindrata, double prezzo){
        this.costruttore=costruttore;
        this.modello=modello;
        this.colore=colore;
        this.cilindrata=cilindrata;
        this.prezzo=prezzo;
    }

    public String getCostruttore(){
        return costruttore;
    }

    public String getModello(){
        return modello;
    }

    public String getColore(){
        return colore;
    }

    public String getCilindrata(){
        return cilindrata;
    }

    public double getPrezzo(){
        return prezzo;
    }

    public double getPrezzoFinale(){
        return prezzo;
    }

    public void setPrezzo(double newPrezzo){
        this.prezzo=newPrezzo;
    }

    public void setColore(String newColore){
        this.colore=newColore;
    }

    public static Auto read(Scanner sc) throws Exception{
        String costruttore, modello, colore, cilindrata;
        double prezzo;

        if(!sc.hasNext()) return null;
        costruttore=sc.next();
        if(!sc.hasNext()) return null;
        modello=sc.next();
        if(!sc.hasNext()) return null;
        colore=sc.next();
        if(!sc.hasNext()) return null;
        cilindrata=sc.next();
        if(!sc.hasNextDouble()) return null;
        prezzo=sc.nextInt();

        return new Auto(costruttore, modello, colore, cilindrata, prezzo);
    }

    public String toString(){
        return costruttore+" "+modello;
    }

    private String costruttore;
    private String modello;
    private String colore;
    private String cilindrata;
    private double prezzo;
}