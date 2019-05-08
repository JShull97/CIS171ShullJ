# Assignment Exercise 22.8

##**22.8 (All prime numbers up to 10,000,000,000) Write a program that finds all prime numbers up to 10,000,000,000. There are approximately 455,052,511 such prime numbers. Your program should meet the following requirements:

Your program should store the prime numbers in a binary data file, named PrimeNumbers.dat. When a new prime number is found, the number is appended to the file.

To find whether a new number is prime, your program should load the prime numbers from the file to an array of the long type of size 10000. If no number in the array is a divisor for the new number, continue to read the next 10000 prime numbers from the data file, until a divisor is found or all numbers in the file are read. If no divisor is found, the new number is prime.

Since this program takes a long time to finish, you should run it as a batch job from a UNIX machine. If the machine is shut down and rebooted, your program should resume by using the prime numbers stored in the binary data file rather than start over from scratch.						
### Grading Notes
-no Unix machine is required - adjust the number to accomodate testing
#### Commments
#### GitHub set up acceptable

- binary data file containing prime numbers properly created
- binary data file is read to use as divisors to determine if the new number is prime

- good use of classes and methods
