import java.awt.Rectangle;
import java.util.Scanner;

public class RettangoloDaTastiera{
	public static void main(String[] arg){

 	Rectangle ret, retMax=null;
	int i=0, imax=0;
    Scanner in = new Scanner(System.in);

	System.out.println("Inserisci la x, la y, la larghezza e l'altezza: ");
	ret = new Rectangle(in.nextInt(), in.nextInt(), 	in.nextInt(), 	in.nextInt());

	while(ret.getX()!=0 || ret.getY()!=0 || ret.getWidth()!=0 || ret.getHeight()!=0){
    	i++;
		if(retMax==null || ret.getWidth()*ret.getHeight()>retMax.getWidth()*retMax.getHeight()){
			retMax=ret;
			imax=i;
		}
		System.out.println("Inserisci la x, la y, la larghezza e l'altezza: ");
		ret = new Rectangle(in.nextInt(), in.nextInt(), 	in.nextInt(), 	in.nextInt());
	}

	if(retMax==null)
		System.out.println("IMPOSSIBILE ESEGURE L'OPERAZIONE.\nSono stati inseriti zero rettangoli");
	else
		System.out.println("Il "+imax+"° ha l'area massima");
	}
}
