/**
* Program: ShuffleArrayList
* Developer: Justin Shull
* Date: 3/19/19
* Purpose: Shuffle an array
*/
import java.util.ArrayList;
import java.util.Arrays;

public class ShuffleArrayList {
   
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList("Justin", "Selena", "Jacob", "Carla", "Eric"));
        shuffle(list);
        
        for (String name : list) System.out.println(name + " ");
    }
    
    public static <E> void shuffle(ArrayList<E> list) { 
        for (int i = 0; i < list.size() - 1; i++) {
            int index = (int) (Math.random() * list.size());
            E temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }
}
