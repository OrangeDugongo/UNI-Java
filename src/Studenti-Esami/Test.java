import java.io.*;
import java.util.Scanner;

public class Test{
    public static void main(String [] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        PrintStream ps = new PrintStream(System.out);
        Segreteria segreteria = new Segreteria("Esami.dati", "Studenti.dati");
        Segreteria filtro;
        int matricola, x=20, y=27;

        ps.println("Inserisci il nome e cognome dello studente.");
        matricola=segreteria.getMatricola(sc.next(), sc.next());

        if(matricola==0)
            ps.println("Errore");
        else{
            filtro = segreteria.filtroMatricola(matricola);
            ps.println("Esami sostenuti dallo studente ");
            filtro.print(ps);
        }

        filtro = segreteria.filtroMatricola(matricola).filtroMaggioreVoto(x).filtroMinoreVoto(y);
        ps.println("Esami con voti compresi tra " + x + " e " + y + " sostenuti dallo studente ");
        filtro.print(ps);
    }
}
