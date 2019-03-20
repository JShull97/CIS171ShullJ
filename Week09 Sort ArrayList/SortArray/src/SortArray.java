/**
* Program: SortArrayList
* Developer: Justin Shull
* Date: 3/19/19
* Purpose: Sort and ArrayList
*/
import java.util.ArrayList;

public class SortArray {

    public static void main(String[] args) {
        // create the array
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 5; i++) list.add(i);
        System.out.println(list);
        shuffle(list);
        System.out.println(list);
        sort(list);
        System.out.println(list);
    }
    
    // shuffle the array so we can sort it 
    public static <E> void shuffle(ArrayList<E> list) { 
        for (int i = 0; i < list.size() - 1; i++) {
            int index = (int) (Math.random() * list.size());
            E temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }
    
    // sort the array
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            E currentMin = list.get(i);
            int min = i;
            
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(currentMin) < 0) {
                    currentMin = list.get(j);
                    min = j;
                }
            }           
            if (min != i) {
                list.set(min, list.get(i));
                list.set(i, currentMin);
            }
        }
    }
}
