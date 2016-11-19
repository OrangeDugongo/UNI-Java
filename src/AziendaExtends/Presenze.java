import java.util.Scanner;

public class Presenze{

    public Presenze(int oreLavoro, String codiceFiscale){
        this.oreLavoro=oreLavoro;
        this.codiceFiscale=codiceFiscale;
    }

    public static Presenze read(Scanner sc) throws Exception{
        String codiceFiscale;
        int oreLavoro;

        if(!sc.hasNext()) return null;
        codiceFiscale=sc.next();
        if(!sc.hasNextInt()) return null;
        oreLavoro=sc.nextInt();

        return new Presenze(oreLavoro, codiceFiscale);
    }

    public int getOreLavoro(){
        return oreLavoro;
    }

    public String getCodiceFiscale(){
        return codiceFiscale;
    }

    private int oreLavoro;
    private String codiceFiscale;
}