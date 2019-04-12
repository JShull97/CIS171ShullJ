/**
* Program: TimeSorts
* Developer: Justin Shull (Revel)
* Date: 4/12/19
* Purpose: Time several sort methods and compare their efficiency
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

 
public class Exam3 extends Application{
    // arrays to be copied and sorted
    static int[] list50 = new int[50];
    static int[] list100 = new int[100];
    static int[] list150 = new int[150];
    static int[] list200 = new int[200];
    static int[] list250 = new int[250];
    static int[] list300 = new int[300];
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        
        // table header
        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Label("Array Size"), new Label("\tSelection Sort"), 
                new Label("\tRadix Sort"), new Label("\tBubble Sort"), new Label("\tMerge Sort"),
                new Label("\tQuick Sort"), new Label("\tHeap Sort"));
        pane.setTop(hBox);
        Line line = new Line(20, 0, 600, 0);
        
        // time the sorts and add the results to the table
        HBox row1 = new HBox();
        row1.getChildren().addAll(new Label("50\t\t"), 
            new Label("\t" + String.valueOf(timeSelectionSort(50))),
            new Label("\t\t" + String.valueOf(timeRadixSort(50))),
            new Label("\t\t" + String.valueOf(timeBubbleSort(50))),
            new Label("\t\t" + String.valueOf(timeMergeSort(50))),
            new Label("\t\t" + String.valueOf(timeQuickSort(50))),
            new Label("\t\t" + String.valueOf(timeHeapSort(50))));
        
        HBox row2 = new HBox();
        row2.getChildren().addAll(new Label("100\t\t"), 
            new Label("\t" + String.valueOf(timeSelectionSort(100))),
            new Label("\t\t  " + String.valueOf(timeRadixSort(100))),
            new Label("\t\t  " + String.valueOf(timeBubbleSort(100))),
            new Label("\t\t  " + String.valueOf(timeMergeSort(100))),
            new Label("\t\t  " + String.valueOf(timeQuickSort(100))),
            new Label("\t\t  " + String.valueOf(timeHeapSort(100))));
        
        HBox row3 = new HBox();
        row3.getChildren().addAll(new Label("150\t\t"), 
            new Label("\t" + String.valueOf(timeSelectionSort(150))),
            new Label("\t\t " + String.valueOf(timeRadixSort(150))),
            new Label("\t\t " + String.valueOf(timeBubbleSort(150))),
            new Label("\t\t " + String.valueOf(timeMergeSort(150))),
            new Label("\t\t  " + String.valueOf(timeQuickSort(150))),
            new Label("\t\t  " + String.valueOf(timeHeapSort(150))));
        
        HBox row4 = new HBox();
        row4.getChildren().addAll(new Label("200\t\t"), 
            new Label("\t" + String.valueOf(timeSelectionSort(200))),
            new Label("\t\t  " + String.valueOf(timeRadixSort(200))),
            new Label("\t\t " + String.valueOf(timeBubbleSort(200))),
            new Label("\t\t " + String.valueOf(timeMergeSort(200))),
            new Label("\t\t " + String.valueOf(timeQuickSort(200))),
            new Label("\t\t " + String.valueOf(timeHeapSort(200))));
        
        HBox row5 = new HBox();
        row5.getChildren().addAll(new Label("250\t\t"), 
            new Label("\t" + String.valueOf(timeSelectionSort(250))),
            new Label("\t\t" + String.valueOf(timeRadixSort(250))),
            new Label("\t\t" + String.valueOf(timeBubbleSort(250))),
            new Label("\t\t" + String.valueOf(timeMergeSort(250))),
            new Label("\t\t " + String.valueOf(timeQuickSort(250))),
            new Label("\t\t  " + String.valueOf(timeHeapSort(250))));
        
        HBox row6 = new HBox();
        row6.getChildren().addAll(new Label("300\t\t"), 
            new Label("\t" + String.valueOf(timeSelectionSort(300))),
            new Label("\t\t" + String.valueOf(timeRadixSort(300))),
            new Label("\t\t" + String.valueOf(timeBubbleSort(300))),
            new Label("\t\t" + String.valueOf(timeMergeSort(300))),
            new Label("\t\t " + String.valueOf(timeQuickSort(300))),
            new Label("\t\t  " + String.valueOf(timeHeapSort(300))));
        
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(hBox, line, row1, row2, row3, row4, row5, row6);
        pane.setLeft(vBox);

        // Set scene
        Scene scene = new Scene(pane, 600, 175);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Time Sorts");
        primaryStage.show();
    }

    public static void main(String[] args) {
        fillArrays();
        launch(args);
    }
    
    // randomly fill each differently sized array to be sorted
    public static void fillArrays() {
        for (int i = 0; i < list50.length; i++) list50[i] = (int)(Math.random() * 100) + 1;
        for (int i = 0; i < list100.length; i++) list100[i] = (int)(Math.random() * 100) + 1;
        for (int i = 0; i < list150.length; i++) list150[i] = (int)(Math.random() * 100) + 1;
        for (int i = 0; i < list200.length; i++) list200[i] = (int)(Math.random() * 100) + 1;
        for (int i = 0; i < list250.length; i++) list250[i] = (int)(Math.random() * 100) + 1;
        for (int i = 0; i < list300.length; i++) list300[i] = (int)(Math.random() * 100) + 1;
    }
    
    // timer methods for each sorting technique
    public long timeSelectionSort(int arrayLength) {
        int[] listCopy = new int[300];
        if (arrayLength == 50) listCopy = list50.clone();
        if (arrayLength == 100) listCopy = list100.clone();
        if (arrayLength == 150) listCopy = list150.clone();
        if (arrayLength == 200) listCopy = list200.clone();
        if (arrayLength == 250) listCopy = list250.clone();
        if (arrayLength == 300) listCopy = list300.clone();
        
        long startTime = System.nanoTime();
        SelectionSort.selectionSort(listCopy);
        long endTime = System.nanoTime();
        
        return endTime - startTime;
    }
    
    public long timeRadixSort(int arrayLength) {
        int[] listCopy = new int[300];
        if (arrayLength == 50) listCopy = list50.clone();
        if (arrayLength == 100) listCopy = list100.clone();
        if (arrayLength == 150) listCopy = list150.clone();
        if (arrayLength == 200) listCopy = list200.clone();
        if (arrayLength == 250) listCopy = list250.clone();
        if (arrayLength == 300) listCopy = list300.clone();
        
        long startTime = System.nanoTime();
        RadixSort.radixSort(listCopy, 3);
        long endTime = System.nanoTime();
        
        return endTime - startTime;
    }
    
    public long timeBubbleSort(int arrayLength) {
        int[] listCopy = new int[300];
        if (arrayLength == 50) listCopy = list50.clone();
        if (arrayLength == 100) listCopy = list100.clone();
        if (arrayLength == 150) listCopy = list150.clone();
        if (arrayLength == 200) listCopy = list200.clone();
        if (arrayLength == 250) listCopy = list250.clone();
        if (arrayLength == 300) listCopy = list300.clone();
        
        long startTime = System.nanoTime();
        BubbleSort.bubbleSort(listCopy);
        long endTime = System.nanoTime();
        
        return endTime - startTime;
    }
    
    public long timeMergeSort(int arrayLength) {
        int[] listCopy = new int[300];
        if (arrayLength == 50) listCopy = list50.clone();
        if (arrayLength == 100) listCopy = list100.clone();
        if (arrayLength == 150) listCopy = list150.clone();
        if (arrayLength == 200) listCopy = list200.clone();
        if (arrayLength == 250) listCopy = list250.clone();
        if (arrayLength == 300) listCopy = list300.clone();
        
        long startTime = System.nanoTime();
        MergeSort.mergeSort(listCopy);
        long endTime = System.nanoTime();
        
        return endTime - startTime;
    }
    public long timeQuickSort(int arrayLength) {
        int[] listCopy = new int[300];
        if (arrayLength == 50) listCopy = list50.clone();
        if (arrayLength == 100) listCopy = list100.clone();
        if (arrayLength == 150) listCopy = list150.clone();
        if (arrayLength == 200) listCopy = list200.clone();
        if (arrayLength == 250) listCopy = list250.clone();
        if (arrayLength == 300) listCopy = list300.clone();
        
        long startTime = System.nanoTime();
        QuickSort.quickSort(listCopy);
        long endTime = System.nanoTime();
        
        return endTime - startTime;
    }
    
    public long timeHeapSort(int arrayLength) {
        int[] listCopy = new int[300];
        if (arrayLength == 50) listCopy = list50.clone();
        if (arrayLength == 100) listCopy = list100.clone();
        if (arrayLength == 150) listCopy = list150.clone();
        if (arrayLength == 200) listCopy = list200.clone();
        if (arrayLength == 250) listCopy = list250.clone();
        if (arrayLength == 300) listCopy = list300.clone();
        
        // Convert array from primitive data type to basic data type
        Integer[] convertedArr = new Integer[listCopy.length];
        int i = 0;
        for (int value : listCopy) {
            convertedArr[i++] = Integer.valueOf(value);
        }
        
        long startTime = System.nanoTime();
        HeapSort.heapSort(convertedArr);
        long endTime = System.nanoTime();
        
        return endTime - startTime;
    }
}
