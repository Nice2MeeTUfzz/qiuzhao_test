package 保融科技线下面试;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        String Processed = str.toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
