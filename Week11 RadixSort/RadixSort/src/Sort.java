import java.util.ArrayList;

public class Sort {
    public static void radixSort(int[] list, int numOfDigits){
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        for (int position = 0; position <= numOfDigits; position++) {
            // clear the buckets
            for (int i = 0; i < buckets.length; i++) buckets[i].clear();
            
            
            // distribute the elements from list to the buckets 
            for (int i = 0; i < list.length; i++) {
                int key = getKey(list[i], position);
                buckets[key].add(list[i]);
            }
            
            // move the elements from the buckets back to list
            int k = 0; // k is an index for list
            for (int i = 0; i < buckets.length; i++) {
                for (int j = 0; j < buckets[i].size(); j++) 
                    list[k++] = buckets[i].get(j);
            }
        }
    }
    
    // return the digit at the specified position
    public static int getKey(int number, int position) {
        int result = 1;
        for (int i = 0; i < position; i++) result *= 10;
        return (number / result) % 10;
    }
}
