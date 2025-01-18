package Palindrome;

public class PalindromeTest {
    public static void main(String[] args) {
        String input1 = "a@b!!b$a";
        String trash1 = "!@$";
        boolean result1 = PalindromeChecker.isPalindrome(input1, trash1);
        System.out.println("Result for input1: " + result1); // Should print true

        String input2 = "?Aa#c";
        String trash2 = "#?";
        boolean result2 = PalindromeChecker.isPalindrome(input2, trash2);
        System.out.println("Result for input2: " + result2); // Should print false
    }
}
