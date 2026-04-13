import java.util.Scanner;


public class Main {
    /**
     * This is a main that gets the int n for Q1+4 and calls the helper function to complete them .
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer n: "); // Get input N from user
        int n = scanner.nextInt();
        if (n < 1) { // Basic validation for positive input
            throw new RuntimeException("Error: " + n + " is not a valid positive number.");
        }

        // --- Question 1 ---
        for (int i = 1; i <= n; i++) {  // Loop from 1 to n to print each num as prime/factors
            if (i == 1) {
                System.out.println("1 = 1"); // Is not prime and has no prime factors
            } else if (isPrime(i)) {
                System.out.println(i + " = Prime"); // If i is prime
            } else {
                factors(i); // Call helper function for to calc factors
            }
        }
        // --- Question 4 --- I assumed that we use the same n as the first user input
        System.out.println("the reversed number for n is: " + reverseNumber(n));
        System.out.println("the resulted Palindrome for n is: " + makePalindrome(n));
    }

    // --- Question 2 ---
    /**
     * This function calc's the sum of a given array by adding each index of the array together and returning that value if the array is empty or null it throws an error.
     */
    public static int sumArray(int[] arr) {
        if (arr == null || arr.length == 0) throw new RuntimeException("Error: " + arr + " is not a valid arr."); // Handle empty/null array
        if (arr.length == 1) return arr[0]; // If only 1 int then its the ans
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // increase total by current element
        }
        return sum;
    }

    // --- Question 3 ---
    /**
     * This function finds the max value of the array by taking the firs index of the array and then checking if the next index is bigger than max index we saved and if true then it will replace it until it went over the whole array.
     */
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) throw new RuntimeException("Error: " + arr + " is not a valid arr."); // Handle empty/null array
        if (arr.length == 1) return arr[0]; // If only 1 int then its the ans
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // update max value
            }
        }
        return max;
    }


    /* ########## Helper functions question 1+4 ########## */
    /**
     * This is a helper function that test if a num is a prime number or not by calculating in the 6k+1/6k-1 algo method - https://en.wikipedia.org/wiki/Primality_test#:~:text=be%20improved%20further.-,Observe%20that%20all%20primes%20greater%20than%205%20are%20of%20the%20form,.,-Generalizing%20further%2C%20all .
     */
    public static boolean isPrime(int i) {
        if (i < 2) return false;
        if (i == 2 || i == 3 || i == 5 || i == 7) return true; // Known small primes
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
     * This function performs the prime factorization of a given int i and prints the result as a multiplication expression by taking the input and repeating through potential divisors starting from 2.
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

    /* ########## Question 4 helper functions ########## */
    /**
     * This function reverses the digits of an int by using % 10 to get last digit and * 10 to shift the num.
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
     * This function checks if a number is a palindrome by compare number to its reverse.
     */
    public static boolean isPalindrome(int n) {
       if (n == reverseNumber(n)) return true; // True if reads same both ways
       else {return false;}
    }

    /**
     * This function creates a palindrome by adding the current num with its revered num with "reverseNumber" function until we get true value from "isPalindrome" function.
     */
    public static int makePalindrome(int n) {
        int current = n;
        while (!isPalindrome(current)) {
            current = current + reverseNumber(current); // sum with reverse on repeat until breaks loop
        }
        return current;
    }
}