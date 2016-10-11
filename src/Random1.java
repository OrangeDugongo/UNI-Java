/*
    Dopo aver analizzato la classe Random, scrivere un programma che simuli
    il lancio di una moneta. Scrivere poi un programma per  simulare il lancio
    di un dado
*/
import java.util.Random;

public class Random1{
    public static void main(String [] args){
        Random rand = new Random();
        int n;
        boolean b;

        if(b=rand.nextBoolean())
            System.out.println("Testa");
        else
            System.out.println("Croce");

        n=rand.nextInt(6)+1;
        System.out.println("dado: "+n);
    }
}
