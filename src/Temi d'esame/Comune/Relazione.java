import java.util.Scanner;

public class Relazione{

    public Relazione(String codiceCapo, String codiceFamigliare, String relazione){
        this.codiceCapo=codiceCapo;
        this.codiceFamigliare=codiceFamigliare;
        this.relazione=relazione;
    }

    public static Relazione read(Scanner sc){
        String codiceCapo, codiceFamigliare, relazione;

        if(!sc.hasNextLine()) return null;
        codiceCapo=sc.nextLine();

        if(!sc.hasNextLine()) return null;
        codiceFamigliare=sc.nextLine();

        if(!sc.hasNextLine()) return null;
        relazione=sc.nextLine();

        return new Relazione(codiceCapo, codiceFamigliare, relazione);
    }

    public String getCodiceCapo(){
        return codiceCapo;
    }

    public String getCodiceFamigliare(){
        return codiceFamigliare;
    }

    public String getRelazione(){
        return relazione;
    }

    private String codiceCapo;
    private String codiceFamigliare;
    private String relazione;
}