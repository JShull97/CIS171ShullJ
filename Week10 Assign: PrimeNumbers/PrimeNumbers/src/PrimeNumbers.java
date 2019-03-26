import java.io.RandomAccessFile;

public class PrimeNumbers {
    final static int ARRAY_SIZE = 100000;
    
    public static void main(String[] args) throws Exception {
    // A list to hold prime numbers
    final long N = 1000002; // Find primes up to N
    long[] primeNumbers = new long[ARRAY_SIZE];

    long number; // A number to be tested for primeness
    RandomAccessFile inout = new RandomAccessFile("PrimeNumbers.dat", "rw");
    if (inout.length() == 0) 
        number = 1;
    else {
        inout.seek(inout.length() - 8);
        number = inout.readLong(); // Get the last prime number in the file 
    }

    int squareRoot = 1;
    
    // To find the prime numbers
    newNumber:while (number <= N) {

        number++;
        inout.seek(0);

        if (squareRoot * squareRoot < number) {
            squareRoot++;
        }

        while (inout.getFilePointer() < inout.length()) {
            int size = readNextBatch(primeNumbers, inout);

            // checks to see if the number is prime
            for (int i = 0; i < size && primeNumbers[i] <= squareRoot; i++) {
                if (number % primeNumbers[i] == 0) { // If true, not prime
                    continue newNumber; // Exit the for loop
                }
            }
        }

        // Add prime number to the file
        System.out.println(number);
        inout.seek(inout.length());
        inout.writeLong(number);
    } // end of newNumber while
    
    inout.close();
  }

  public static int readNextBatch(long[] primeNumbers, RandomAccessFile inout) {
    int size = 0;
    try {
      while (inout.getFilePointer() < inout.length() && size < ARRAY_SIZE) {
        primeNumbers[size++] = inout.readLong();
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    return size;
  }
}