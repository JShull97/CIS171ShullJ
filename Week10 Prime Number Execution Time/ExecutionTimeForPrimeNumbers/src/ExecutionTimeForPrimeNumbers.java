/**
* Program: ExecutionTimeForPrimeNumbers
* Developer: Justin Shull (Revel)
* Date: 3/31/19
* Purpose: Compare the time it takes for different methods to find all prime numbers up to different limits
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExecutionTimeForPrimeNumbers extends Application{
    long time22_5;
    long time22_6;
    long time22_7;

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(5);
        VBox vBox1 = new VBox(5);
        VBox vBox2 = new VBox(5);
        VBox vBox3 = new VBox(5);
        HBox hBox = new HBox(5);
        
        vBox.getChildren().addAll(new Label("Listings"), new Label("10"), new Label("100"), new Label("200"));
        
        // Because only having one label had values overwrite itself
        Label value = new Label();
        Label value1 = new Label();
        Label value2 = new Label();
        Label value3 = new Label();
        Label value4 = new Label();
        Label value5 = new Label();
        Label value6 = new Label();
        Label value7 = new Label();
        Label value8 = new Label();
        
        
        timeMethods(10);
        value.setText(Long.toString(time22_5));
        vBox1.getChildren().addAll(new Label("  22_5"), value);
        value1.setText(Long.toString(time22_6));
        vBox2.getChildren().addAll(new Label("  22_6"), value1);
        value2.setText(Long.toString(time22_7));
        vBox3.getChildren().addAll(new Label("  22_7"), value2);
        
        timeMethods(100);
        value3.setText(Long.toString(time22_5));
        vBox1.getChildren().add(value3);
        value4.setText(Long.toString(time22_6));
        vBox2.getChildren().add(value4);
        value5.setText(Long.toString(time22_7));
        vBox3.getChildren().add(value5);
        
        timeMethods(200);
        value6.setText(Long.toString(time22_5));
        vBox1.getChildren().add(value6);
        value7.setText(Long.toString(time22_6));
        vBox2.getChildren().add(value7);
        value8.setText(Long.toString(time22_7));
        vBox3.getChildren().add(value8);
        
        // Because trying to add tab once caused errors
        Label tab = new Label("\t");
        Label tab1 = new Label("\t");
        Label tab2 = new Label("\t");
        hBox.getChildren().addAll(vBox);
        hBox.getChildren().add(tab);
        hBox.getChildren().add(vBox1);
        hBox.getChildren().add(tab1);
        hBox.getChildren().add(vBox2);
        hBox.getChildren().add(tab2);
        hBox.getChildren().add(vBox3);
        
        Scene scene = new Scene(hBox, 350, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Execution Time to find Prime numbers");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void timeMethods(int upTo) {
        long startTime = System.nanoTime();
        Listing22_5(upTo);
        long endTime = System.nanoTime();
        time22_5 = endTime - startTime;
        startTime = System.nanoTime();
        Listing22_6(upTo);
        endTime = System.nanoTime();
        time22_6 = endTime - startTime;
        System.out.println("22_6 took: " + (endTime - startTime));
        startTime = System.nanoTime();
        Listing22_7(upTo);
        endTime = System.nanoTime();
        time22_7 = endTime - startTime;
        System.out.println("22_7 took: " + time22_7);
    }
    
    public static void Listing22_5(int n) {

        final int NUMBER_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness

        System.out.println("The prime numbers are:");

        // Repeatedly find prime numbers
        while (number <= n) {
        // Assume the number is prime
        boolean isPrime = true; // Is the current number prime?

        // ClosestPair if number is prime
        for (int divisor = 2; divisor <= (int)(Math.sqrt(number)); divisor++) {
            if (number % divisor == 0) { // If true, number is not prime
            isPrime = false; // Set isPrime to false          
            break; // Exit the for loop
            }
        }

        // Print the prime number and increase the count
        if (isPrime) {
            count++; // Increase the count

            if (count % NUMBER_PER_LINE == 0) {
            // Print the number and advance to the new line
                //System.out.printf("%7d\n", number);
            }
        else
            System.out.printf("%7d", number);
        }

        // Check if the next number is prime
        number++;
        }
    
        System.out.println("\n" + count + " prime(s) less than or equal to " + n);
    }
    
    public static void Listing22_6(int n) {

        // A list to hold prime numbers
        java.util.List<Integer> list = new java.util.ArrayList<>(); 

        final int NUMBER_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness
        int squareRoot = 1; // Check whether number <= squareRoot

        System.out.println("The prime numbers are \n");

        // Repeatedly find prime numbers
        while (number <= n) {
        // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            if (squareRoot * squareRoot < number) squareRoot++;

        // Test whether number is prime
            for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
                if (number % list.get(k) == 0) { // If true, not prime
                    isPrime = false; // Set isPrime to false          
                    break; // Exit the for loop
                }
            }

      // Print the prime number and increase the count
    if (isPrime) {
            count++; // Increase the count
            list.add(number); // Add a new prime to the list
            if (count % NUMBER_PER_LINE == 0) {
            // Print the number and advance to the new line
                System.out.println(number);
            }
            else
                System.out.print(number + " ");
    }
    // Check if the next number is prime
            number++;
        }

    System.out.println("\n" + count + " prime(s) less than or equal to " + n);
  }
    
    public static void Listing22_7(int n) {       

        boolean[] primes = new boolean[n + 1]; // Prime number sieve

        // Initialize primes[i] to true
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true; 
        }

        for (int k = 2; k <= n / k; k++) {
            if (primes[k]) {
                for (int i = k; i <= n / k; i++) {
                    primes[k * i] = false; // k * i is not prime
                }
            }
        }

        final int NUMBER_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers found so far
        // Print prime numbers
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                count++;
                if (count % 10 == 0) 
                    System.out.printf("%7d\n", i);
                else
                    System.out.printf("%7d", i);          
            }
        }

        System.out.println("\n" + count + " prime(s) less than or equal to " + n);
      }

}
