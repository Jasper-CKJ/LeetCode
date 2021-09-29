/**
 * @author jasper
 * @create 2021-09-29 14:03
 */
public class PalindromeNumber {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int result = reverse(x);
        return result == x;
    }
}
