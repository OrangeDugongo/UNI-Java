import java.io.*;
import java.awt.*;
public class Rettangolo{
	public static void main(String [] args){
		Rectangle box = new Rectangle(2,3, 20,30);
		Rectangle box2 = new Rectangle(3,4, 10, 40);
		double p1, p2, a1, a2;

	if(box.getY() < box2.getY())
			System.out.println("Il box 1 è più in alto");
		else
			System.out.println("Il box 2 è più in alto");
		p1=2*(box.getHeight() + box.getWidth());

		p2=2*(box2.getHeight() + box2.getWidth());

		if(p1>p2)
			System.out.println("Il box 1 ha perimetro maggiore");
		else
			System.out.println("Il box 2 ha perimetro maggiore");

		a1=box.getHeight() * box.getWidth();
		
		a2=box2.getHeight() * box2.getWidth();

		if(a1>a2)
			System.out.println("Il box 1 ha area maggiore");
		else
			System.out.println("Il box 2 ha area maggiore");
	}
}
