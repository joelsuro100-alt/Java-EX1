import java.util.Scanner;

/**
 * This class completes Assignment 1 for Intro to CS (Ariel University).
 * The logic follows the style of explaining steps via numbered lists.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1) Get input N from user
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();

        // 2) Basic validation for positive input
        if (n < 1) {
            System.err.println("Error: " + n + " is not a valid positive number.");
            System.exit(-1);
        }

        // 3) Loop from 1 to n to print prime/factors as per Q1 requirements
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.println("1 = 1"); // 1 is not prime and has no prime factors
            } else if (isPrime(i)) {
                System.out.println(i + " = Prime"); // Matches the "i = Prime" format
            } else {
                factors(i); // Call helper function for composite numbers
            }
        }
    }

    /* ########## Question 1: Prime & Factors ########## */

    /**
     * 1) check if i is a prime number.
     * 2) if i=2,3,5,7 then return true.
     * 3) if i<2 return false (0,1).
     * 4) check multipliers of 2,3,5,7.
     * 5) use loop of 6k +/- 1 to check for other prime factors until root.
     */
    public static boolean isPrime(int i) {
        if (i == 2 || i == 3 || i == 5 || i == 7) return true; // Known small primes
        if (i < 2) return false;
        if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0) return false;

        long root = (long) Math.sqrt(i) + 1;
        // Logic check: check if i is divisible by j (6k+/-1 form)
        for (int j = 11; j <= root; j += 6) {
            if (i % j == 0) return false;       // checks 6k - 1
            if (i % (j + 2) == 0) return false; // checks 6k + 1
        }
        return true;
    }

    /**
     * 1) function to print prime factors of i.
     * 2) start loop from k=2 until sqrt(i).
     * 3) divide i by k repeatedly while i % k == 0.
     * 4) print the factor and '*' as separator.
     * 5) print the remaining part if it is > 1.
     */
    public static void factors(int i) {
        System.out.print(i + " = ");
        int temp = i;

        for (int k = 2; k * k <= temp; k++) {
            while (temp % k == 0) {
                temp = temp / k;
                if (temp > 1) {
                    System.out.print(k + " * "); // Add '*' if more factors remain
                } else {
                    System.out.print(k); // Last factor doesn't need '*'
                }
            }
        }

        if (temp > 1) {
            System.out.print(temp); // Remaining prime factor
        }
        System.out.println(); // New line for next number
    }

    /* ########## Question 2: Sum Array ########## */

    /**
     * 1) receives an array and returns sum of elements.
     * 2) check if array is null or empty (length == 0).
     * 3) use a loop to iterate and add each value to total.
     */
    public static int sumArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0; // handle empty/null array
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // increase total by current element
        }
        return sum;
    }

    /* ########## Question 3: Max in Array ########## */

    /**
     * 1) receives an array and finds maximum value.
     * 2) if empty, return Integer.MIN_VALUE or error indicator.
     * 3) initialize max with the first element.
     * 4) compare each element and update max if needed.
     */
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) return Integer.MIN_VALUE; // Return special value for empty
        int max = arr;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // update max value
            }
        }
        return max;
    }

    /* ########## Question 4: Mirror Number ########## */

    /**
     * 1) reverses the digits of an integer.
     * 2) use % 10 to get last digit and * 10 to shift.
     */
    public static int reverseNumber(int n) {
        int reversed = 0;
        int temp = n;
        while (temp > 0) {
            reversed = reversed * 10 + (temp % 10);
            temp /= 10;
        }
        return reversed;
    }

    /**
     * 1) checks if a number is a palindrome.
     * 2) compare number to its reverse.
     */
    public static boolean isPalindrome(int n) {
        return n == reverseNumber(n); // True if reads same both ways
    }

    /**
     * 1) adds number to its reverse until palindrome is found.
     * 2) loop while isPalindrome is false.
     */
    public static int makePalindrome(int n) {
        int current = n;
        while (!isPalindrome(current)) {
            current = current + reverseNumber(current); // sum with reverse
        }
        return current;
    }
}