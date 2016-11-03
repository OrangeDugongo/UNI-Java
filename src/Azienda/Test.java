import java.util.Scanner;

public class Test{
    public static void main(String [] args) throws Exception{
        Azienda azienda1 = new Azienda("Sedi.dati", "Personale.dati");
        //azienda1.print(System.out);
        //azienda1.filtroSedeId("sedeid2").print(System.out);
        azienda1.filtroNome("nome").print(System.out);
    }
}
