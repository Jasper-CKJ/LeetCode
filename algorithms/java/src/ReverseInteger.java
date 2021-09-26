/**
 * @author jasper
 * @create 2021-09-26 18:14
 */
public class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10){
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
