import java.io.PrintStream;
import java.util.Scanner;
/**
    This class manages objects characterised by a name, a surname and a title.
*/
public class Name{

    /**
        This constructor sets the values of name and surname, and uses a default title.
        @param name The value of the name.
        @param sname The value of the surname.
    */
    public Name(String name, String sname){
        this.name=name;
        this.sname=sname;
        title="";
    }


    /**
        This constructor sets the values of name, surname and title.
        @param title The value of the title
        @param name The value of the name.
        @param sname The value of the surname.
    */
    public Name(String title, String name, String sname){
        this.name=name;
        this.sname=sname;
        this.title=title;
    }


    /**
        This method returns the initials as a String object.
        @return the string of the initials.
    */
    public String getInitials(){
        return name.substring(0, 1).concat(". ").concat(sname.substring(0,1)).concat(".");
    }


    /**
        This method returns a String object that contains both name and surname, strictly in this order.
        @return A string object made up by name and surname.
    */
    public String getNameSurname(){
        return name.concat(" ").concat(sname);
    }


    /**
        This method returns a String object that contains title, name and surname, strictly in this order.
        @return A string object made up by title,surname and name.
    */
    public String getTitleNameSurname(){
        return title.concat(" ").concat(name).concat(" ").concat(sname);
    }


    /**
        This method set a new value for the title of an object.
        @param title A new value for the title of the object.
    **/
    public void setTitle(String title){
        this.title=title;
    }


    /**
        Indicates whether some other object is "equal to" this one.
        @param n the reference object with which to compare.
        @return a boolean.
    **/
    public boolean equals(Name n){
        return this.name.equals(n.name) && this.sname.equals(n.sname) && this.title.equals(n.title);
    }


    /**
        This method prints the value of the istance variables.
        @param ps The object which must print the values.
    **/
    public void print(PrintStream ps){
        ps.println(title);
        ps.println(name);
        ps.println(sname);
    }


    /**
        This method reads the value of the istance variables.
        @param sc The Scanner.
        @return The new Name
    **/
    public static Name read(Scanner sc) throws Exception{
        String title, name, sname;
        if(sc.hasNext()){
            title=sc.nextLine();
            if(sc.hasNext()){
                name = sc.nextLine();
                if(sc.hasNext()){
                    sname=sc.nextLine();
                    return new Name(title, name, sname);
                }
            }
        }
        return null;
    }


    private String name;
    private String sname;
    private String title;
}
