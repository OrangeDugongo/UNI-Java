import java.io.PrintStream;
import java.util.Scanner;

public class Dirigente extends Dipendente{

    public Dirigente(String codiceFiscale, String nome, String cnome, double paga, String areaResponsabilità){
        super(codiceFiscale, nome, cnome, paga);
        this.areaResponsabilità=areaResponsabilità;
    }

    public void print(PrintStream ps){
        super.print(ps);
        ps.println(areaResponsabilità);
    }

    public static Dirigente read(Scanner sc) throws Exception{
        String nome, cnome, areaResponsabilità, codiceFiscale;
        double paga;
        if(!sc.hasNext()) return null;
        codiceFiscale=sc.next();
        if(!sc.hasNext()) return null;
        nome=sc.next();
        if(!sc.hasNext()) return null;
        cnome=sc.next();
        if(!sc.hasNext()) return null;
        areaResponsabilità=sc.next();
        if(!sc.hasNextDouble()) return null;
        paga=sc.nextDouble();

        return new Dirigente(codiceFiscale, nome, cnome, paga, areaResponsabilità);
    }

    private String areaResponsabilità;
}