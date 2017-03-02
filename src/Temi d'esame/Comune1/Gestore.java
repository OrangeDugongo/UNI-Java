import java.util.ArrayList;
import java.util.Scanner;

public class Gestore{

    public Gestore(Scanner scC, Scanner scP){
        ArrayList<Cittadino> cittadini=new ArrayList<Cittadino>();
        ArrayList<Famiglia> famiglie=new ArrayList<Famiglia>();

        Cittadino famiglare;
        Cittadino c=Cittadino.read(scC);
        while(c!=null){
            cittadini.add(c);
            c=Cittadino.read(scC);
        }

        Parentella p = Parentella.read(scP);
        while(p!=null){
            try{
                c=searchCapo(p.getCodiceCapo());
                famiglare=searchFamigliare(p.getCodiceFamigliare());
                
            }
            
        }
    }
    private ArrayList<Cittadino> cittadini;
    private ArrayList<Famiglia> famiglie;
}