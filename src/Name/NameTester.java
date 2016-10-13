import java.io.*;

public class NameTester{
    public static void main(String [] args){
        Name persona1 = new Name();

        persona1.setTitolo("Sig.");
        System.out.println(persona1.title());

        persona1 = new Name("Mario", "Rossi");
        persona1.setTitolo("Sig.");
        System.out.println(persona1.iniziali());

        persona1 = new Name("Maria", "Bianchi", "Sig.na");
        System.out.println(persona1.nomeCognome());
        System.out.println(persona1.title());




    }
}
