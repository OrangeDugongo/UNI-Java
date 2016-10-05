import java.util.Scanner;
public class PariDispari{
	public static void main(String[] arg){
		System.out.print("Inserisci un numero: ");
		Scanner s = new Scanner(System.in);
		int value=s.nextInt();
		if(value%2==0)
			System.out.println("Pari");
		else
			System.out.println("Dispari");
	}
}
