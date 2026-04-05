import java.util.Scanner;
public class void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n= scanner.nextInt();
    if (n <= 1){ // check if N is negative
        System.out.println(n + "not valid number");
    }
    for (int i=1; i <= n; i++) {
        if (isPrime(i) = true) {
             System.out.println(i + "is a prime number");
        }
    }
}

/*
public static void factors(String[] args) {
    // קבלת מספר מתוך ארגומנטים של שורת הפקודה
    if (args.length == 0) {
        return;
    }

    long n = Long.parseLong(Arrays.toString(args));
    System.out.print("הפירוק לגורמים ראשוניים של " + n + " הוא: ");

    // עבור כל גורם פוטנציאלי i, עד לשורש של n
    for (long i = 2; i * i <= n; i++) {

        // אם i הוא גורם של n, יש לחלק אותו שוב ושוב עד שאינו גורם יותר
        while (n % i == 0) {
            System.out.print(i + " ");
            n = n / i;
        }
    }
    // אם נותר גורם הגדול מהשורש של n המקורי, הוא בהכרח ראשוני
    if (n > 1) {
        System.out.println(n);
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
    for (int i = 11; i <= root; i += 6) {
        if (i % i == 0) return false;       // checks 6k - 1
        if (i % (i + 2) == 0) return false; // checks 6k + 1
    }
    return true;
}
