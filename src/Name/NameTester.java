import java.io.*;
import java.util.Scanner;

public class NameTester{
    public static void main(String [] args) throws Exception{

        Scanner sc = new Scanner(new File("src"));
        Name persona = Name.read(sc);
        Name persona1;

        if(persona!=null)
            persona.print(System.out);
        else
            System.out.println("ERROR");

        persona.setTitle("Hand of the Queen");
        persona.print(System.out);
        System.out.println(persona.getInitials());  //We expect T. L.

        persona1 = new Name("King in the North", "Jon", "Snow");
        System.out.println(persona1.getNameSurname());  //We expect Jon Snow
        System.out.println(persona1.getTitleNameSurname()); //We expect a spoiler

        if(persona.equals(persona1))    //We expect Different
            System.out.println("Equal");
        else
            System.out.println("Different");

    }
}
