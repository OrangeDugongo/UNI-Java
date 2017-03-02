import java.util.Scanner;

public class Parentela{

    public Parentela(String codiceCapo, String codiceFamigliare, String relazione){
        this.codiceCapo=codiceCapo;
        this.codiceFamigliare=codiceFamigliare;
        this.relazione=relazione;
    }

    public static void read(Scanner sc){
        String codiceCapo, codiceFamigliare, relazione;

        if(!sc.hasNextLine()) return null;
        codiceFiscale=sc.nextLine();

        if(!sc.hasNextLine()) return null;
        nome=sc.nextLine();

        if(!sc.hasNextLine()) return null;
        cnome=sc.nextLine();

        return new Parentela(codiceCapo, codiceFamigliare, relazione);
    }

    private String codiceCapo;
    private String codiceFamigliare;
    private String relazione;
}