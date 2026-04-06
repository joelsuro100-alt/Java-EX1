import java.util.Arrays;
import java.util.Scanner;

public class main { // שם המחלקה

    public static void main(String[] args) { // מתודת הכניסה
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 1) { // check if N is negative
            System.out.println(n + "not valid number");
        }
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i + " "+ "is a prime number");
            }
            else{
                factors(i);
            }
        }
    }

    //////////////// Priate Functions ////////////////
    public static void factors(int i) {
        System.out.print(i + " = "); // print the structure as required
        // עבור כל גורם פוטנציאלי i, עד לשורש של n
        // שונה ל-int במקום long להתאמה לסוג הקלט
        for (int k = 2; k * k <= i; k++) { //
            // אם i הוא גורם של n, יש לחלק אותו שוב ושוב עד שאינו גורם יותר
            while (i % k == 0) {
                System.out.print(k + " * "); // הוספת כוכבית כנדרש במטלה 1
                i = i / k;
            }
        }
        // אם נותר גורם הגדול מהשורש של n המקורי, הוא בהכרח ראשוני
        if (i > 1) {
            System.out.println(i);
        } else {
            System.out.println();
        }
    }

    public static boolean isPrime(int i) {
        if (i == 2 || i == 3 || i == 5 || i == 7) return true; // 2 & 3 & 5 & 7 is prime number
        if (i < 2) return false;  // 0,1 are not prime and can confuse our function
        if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
            return false; //if it divides by these num It's even or a multiplier so not prime
        // every prime num is always in the form of 6k+1 || 6k-1
        long root = (long) Math.sqrt(i) + 1; // the highest num we need to check it the root (cant divide bigger than root to become n)
        for (int j = 11; j <= root; j += 6) {
            if (j % i == 0) return false;       // checks 6k - 1
            if (j % (i + 2) == 0) return false; // checks 6k + 1
        }
        return true;
    }
}