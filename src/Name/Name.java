import  java.io.PrintStream;
/**
    This class manages objects characterised by a name, a surname and a title.
*/
public class Name{

    /**
        This constructor uses a default title, name and surname.
    */
    public Name(){
        name="";
        sname="";
        title="";
    }


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
        @param name The value of the name.
        @param sname The value of the surname.
        @param title The value of the title
    */
    public Name(String name, String sname, String title){
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
        This method prints the value of the istance variables.
        @param ps The object which must print the values.
    **/
    public void print(PrintStream ps){
        ps.println(getTitleNameSurname());
    }


    private String name;
    private String sname;
    private String title;
}
