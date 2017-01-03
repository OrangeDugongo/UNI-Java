import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.File;

public class Test{

    public static void main(String [] args)throws Exception{
        Scanner sc=new Scanner(new File("testo.dat"));
        Comparator<Item> comp=new ItemComparator();
        Set<Item> albero=new TreeSet<Item>(comp);
        Item i=Item.read(sc);
        while(i!=null){
            for(Item item: albero){
                if(item.getParola().equals(i.getParola())){
                    item.setAdd();
                    break;
                }
            }
            albero.add(i);
            i=Item.read(sc);
        }

        for(Item item: albero)
            item.print(System.out);

    }
}

class ItemComparator implements Comparator<Item>{
    public int compare(Item i1, Item i2){
        return i1.getParola().compareToIgnoreCase(i2.getParola());
    }
}