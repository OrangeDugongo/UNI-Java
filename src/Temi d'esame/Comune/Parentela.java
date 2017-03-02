public class Parentela{

    public Parentela(Cittadino c, String relazione){
        this.parente=c;
        this.relazione=relazione;
    }

    public String toString(){
        return parente.toString()+" "+relazione;
    }

    public String getRelazione(){
        return relazione;
    }

    private Cittadino parente;
    private String relazione;
}