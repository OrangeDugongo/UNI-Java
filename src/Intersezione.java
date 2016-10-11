/*
    Scrivere un programma che calcola l’intersezione di due rettangoli
*/

import java.awt.Rectangle;
import java.util.Scanner;


public class Intersezione{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        Rectangle box1=null, box2=null, inter=null;

        System.out.println("Inserisci la x, la y, la larghezza e l'altezza: ");
		box1 = new Rectangle(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());

        System.out.println("Inserisci la x, la y, la larghezza e l'altezza: ");
		box2 = new Rectangle(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());

        System.out.println(box1.union(box2).toString());

    }
}
