import java.util.Scanner;

public class Fibonacci {

    // Fibonacci using recursion
    public static long fibonacciRecursive(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    // Fibonacci using iteration
    public static long fibonacciIterative(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                long temp = a;
                a = b;
                b = temp + b;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        // Measure time for the recursive method
        long startTimeRec = System.nanoTime();
        long fibRecursive = fibonacciRecursive(n);
        long endTimeRec = System.nanoTime();
        long elapsedTimeRec = endTimeRec - startTimeRec;
        System.out.println("Fibonacci (Recursive) of " + n + " is " + fibRecursive);
        System.out.println("Time taken by recursive method: " + elapsedTimeRec + " nanoseconds");

        // Measure time for the iterative method
        long startTimeIter = System.nanoTime();
        long fibIterative = fibonacciIterative(n);
        long endTimeIter = System.nanoTime();
        long elapsedTimeIter = endTimeIter - startTimeIter;
        System.out.println("Fibonacci (Iterative) of " + n + " is " + fibIterative);
        System.out.println("Time taken by iterative method: " + elapsedTimeIter + " nanoseconds");

        scanner.close();
    }
}
