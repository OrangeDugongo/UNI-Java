import java.util.Scanner;
import java.io.PrintStream;

public class Esame{

    public Esame(int matricola, String nomeEsame, String data, int voto){
        this.nomeEsame=nomeEsame;
        this.voto=voto;
        this.matricola=matricola;
        this.data=data;
    }

    public int getVoto(){
        return voto;
    }

    public int getMatricola(){
        return matricola;
    }

    public String getNomeEsame(){
        return nomeEsame;
    }

    public String getData(){
        return data;
    }

    public String toString(){
        return matricola + " " + nomeEsame + " " + data + " " + voto;
    }

    public void print(PrintStream ps){
        ps.println(toString());
    }

    public static Esame read(Scanner sc) throws Exception{
        String nomeEsame;
        int voto;
        int matricola;
        String data;

        if(!sc.hasNextInt()) return null;
        matricola=sc.nextInt();
        if(!sc.hasNext()) return null;
        nomeEsame=sc.next();
        if(!sc.hasNext()) return null;
        data=sc.next();
        if(!sc.hasNextInt()) return null;
        voto=sc.nextInt();

        return new Esame(matricola, nomeEsame, data, voto);
    }

    private String nomeEsame;
    private String data;
    private int voto;
    private int matricola;
}
