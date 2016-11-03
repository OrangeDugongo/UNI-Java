import java.util.Date;
import java.util.Scanner;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

public class Impiegato{

    public Impiegato(String codiceFiscale, String nome, String cnome, String sedeId, String livello, double paga, Date data){

        this.codiceFiscale=codiceFiscale;
        this.nome=nome;
        this.cnome=cnome;
        this.sedeId=sedeId;
        this.livello=livello;
        this.paga=paga;
        this.data=data;
    }

    public String getCodiceFiscale(){
        return codiceFiscale;
    }

    public String getNome(){
        return nome;
    }

    public String getCnome(){
        return cnome;
    }

    public String getSedeId(){
        return sedeId;
    }

    public String getLivello(){
        return livello;
    }

    public Date getData(){
        return data;
    }

    public double getPaga(){
        return paga;
    }

    public void setPaga(double newPaga){
        paga=newPaga;
    }

    public void setLivello(String newLivello){
        livello=newLivello;
    }

    public void setSedeId(String newSedeId){
        sedeId=newSedeId;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return codiceFiscale+" "+nome+" "+cnome+" "+sdf.format(data)+" "+livello+" "+paga+"€.";
    }

    public void print(PrintStream ps){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ps.println(codiceFiscale);
        ps.println(nome);
        ps.println(cnome);
        ps.println(sedeId);
        ps.println(livello);
        ps.println(paga);
        ps.println(sdf.format(data));
    }

    public static Impiegato read(Scanner sc) throws Exception{
        String codiceFiscale, nome, cnome, sedeId, livello;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        double paga;

        if(!sc.hasNext()) return null;
        codiceFiscale=sc.next();
        if(!sc.hasNext()) return null;
        nome=sc.next();
        if(!sc.hasNext()) return null;
        cnome=sc.next();
        if(!sc.hasNext()) return null;
        sedeId=sc.next();
        if(!sc.hasNext()) return null;
        livello=sc.next();
        if(!sc.hasNextDouble()) return null;
        paga=sc.nextDouble();
        if(!sc.hasNextLine()) return null;
        data = sdf.parse(sc.next());

        return new Impiegato(codiceFiscale, nome, cnome, sedeId, livello, paga, data);
    }


    private String codiceFiscale;
    private String nome;
    private String cnome;
    private Date data;
    private String livello;
    private double paga;
    private String sedeId;

}
