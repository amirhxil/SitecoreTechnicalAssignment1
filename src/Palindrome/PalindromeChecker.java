package Palindrome;

public class PalindromeChecker {
    public static boolean isPalindrome(String inputString, String trashSymbols) {
        int left = 0, right = inputString.length() - 1;

        while (left < right) {
            while (left < right && trashSymbols.indexOf(inputString.charAt(left)) != -1) {
                left++;
            }
            while (left < right && trashSymbols.indexOf(inputString.charAt(right)) != -1) {
                right--;
            }

            if (Character.toLowerCase(inputString.charAt(left)) != Character.toLowerCase(inputString.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("a@b!!b$a", "!@$")); // true
        System.out.println(isPalindrome("?Aa#c", "#?"));    // false
    }
}

