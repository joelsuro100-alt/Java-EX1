import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class mainTest {

    @org.junit.jupiter.api.Test
    void main() {
        int n = 10;
        //main();
    }

    @Test
    void isPrime() {
        boolean prime = main.isPrime(2);
        assertTrue(prime);
        prime = main.isPrime(3);
        assertTrue(prime);
        prime = main.isPrime(29);
        assertTrue(prime);
        prime = main.isPrime(33331);
        assertTrue(prime);
    }

    @org.junit.jupiter.api.Test
    void factors() {
    }

    @org.junit.jupiter.api.Test
    void sumArray() {
    }

    @org.junit.jupiter.api.Test
    void findMax() {
    }

    @org.junit.jupiter.api.Test
    void reverseNumber() {
    }

    @org.junit.jupiter.api.Test
    void isPalindrome() {
    }

    @org.junit.jupiter.api.Test
    void makePalindrome() {
    }
}