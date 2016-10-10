import java.awt.Rectangle;
import java.util.Scanner;

public class Esercizio3{

	public static boolean area(Rectangle r, Rectangle max){
		if(max==null || r.getWidth()*r.getHeight() > max.getWidth()*max.getHeight())
			return true;

		return false;
	}

	public static boolean perimetro(Rectangle r, Rectangle max){
		if(max==null || r.getWidth()+r.getHeight() > max.getWidth()+max.getHeight())
			return true;

		return false;
	}

	public static boolean posizione(Rectangle r, Rectangle max){
		if(max==null || r.getY() > max.getY())
			return true;

		return false;
	}

	public static void main(String[] arg){

	 	Rectangle ret, perimetroMax=null, areaMax=null, posMax=null;
		int i=0, iPerimetro=0, iArea=0, iPosizione=0;
		Scanner in = new Scanner(System.in);

		System.out.println("Inserisci la x, la y, la larghezza e l'altezza: ");
		ret = new Rectangle(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());

		while((ret.getX()!=0 || ret.getY()!=0) && (ret.getWidth()!=0 || ret.getHeight()!=0)){
			i++;

			if(perimetro(ret, perimetroMax)){
				perimetroMax=ret;
				iPerimetro=i;
			}

			if(area(ret, areaMax)){
				areaMax=ret;
				iArea=i;
			}

			if(posizione(ret, posMax)){
				posMax=ret;
				iPosizione=i;
			}

			System.out.println("Inserisci la x, la y, la larghezza e l'altezza: ");
			ret = new Rectangle(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
		}

		if(areaMax==null)
			System.out.println("IMPOSSIBILE ESEGUIRE L'OPERAZIONE.\nSono stati inseriti zero rettangoli");
		else{
			System.out.println("Il "+iArea+"° rettangolo ha l'area massima");
			System.out.println("Il "+iPerimetro+"° rettangolo ha il perimetro massimo");
			System.out.println("Il "+iPosizione+"° rettangolo ha la posizione massima");
		}
	}
}
