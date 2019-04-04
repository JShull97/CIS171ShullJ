/**
* Program: RadixSort
* Developer: Justin Shull (Revel)
* Date: 4/2/19
* Purpose: Sort an ArrayList using a Radix sort
*/
public class RadixSort {

    public static void main(String[] args) {
        int[] list = new int[100];
        
        for (int i = 0; i < list.length; i++) list[i] = (int)(Math.random() * 100) + 1;
        
        Sort.radixSort(list, 3);
        
        for (int i = 0; i < list.length; i++) {
            if (i % 10 == 0) System.out.print("\n");
            System.out.print(list[i] + " ");
        }
    }
}
