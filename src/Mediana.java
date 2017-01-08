import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Random;

public class Mediana{
    public static void main(String [] args){

        ArrayList<Integer> list =new ArrayList<Integer>();
        Random rand = new Random();
        for(int i=0; i<rand.nextInt(100); i++){
            list.add(rand.nextInt(100));
        }
        Comparator<Integer> cmp=new IntComparator();
        Collections.sort(list, cmp);

        for(Integer item: list){
            System.out.println(item);
        }
    
    }

}

class IntComparator implements Comparator<Integer>{
    public int compare(Integer i1, Integer i2){
        return (-1)*i1.compareTo(i2);
    }
}