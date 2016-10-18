import java.io.*;

public class NameTester{
    public static void main(String [] args){
        
        Name persona = new Name();
        persona.setTitle("Sig.");
        persona.print(System.out);  //We expect Sig.

        persona = new Name("Mario", "Rossi");
        System.out.println(persona.getInitials());  //We expect M. R.

        persona = new Name("Jon", "Snow", "King in the North");
        System.out.println(persona.getNameSurname());  //We expect Jon Snow
        System.out.println(persona.getTitleNameSurname()); //We expect a very big spoiler

    }
}
