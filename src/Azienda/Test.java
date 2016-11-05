import java.io.PrintStream;

public class Test{
    public static void main(String [] args) throws Exception{
        Azienda azienda = new Azienda("Sedi.dati", "Personale.dati");
        PrintStream ps = System.out;

        ps.println("\n+ Stampa degli impiegati in US con paga minore di 20000");
        azienda.filtroStato("US").filtroPagaMinore(20000).print(ps);

        ps.println("\n+ Stampa degli impiegati con paga compresa tra 50000 e 80000");
        azienda.filtroPagaMinore(80000).filtroPagaMaggiore(50000).print(ps);

        ps.println("\n+ Stampa degli impiegati nella sede PP01 nati dopo il 1990");
        azienda.filtroNatoDopo("31/12/1989").filtroSedeId("PP01").print(ps);

        ps.println("\n+ Stampa degli impiegati nella sede PP01 nati dopo il 1990");
        azienda.filtroSedeId("PP01").filtroNatoDopo("31/12/1989").print(ps);

        ps.println("\n+ Stampa degli impiegati di livello over9000");
        azienda.filtroLivello("Over9000").print(ps);
    }
}
