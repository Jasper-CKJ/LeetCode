import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jasper
 * @create 2021-09-27 18:27
 */
public class String2Integer {

    private static final Pattern PATTERN = Pattern.compile("^[+-]?\\d+");

    public int myAtoi1(String s) {
        int sign = 1;
        int ans = 0, pop = 0;
        boolean hasSign = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' && !hasSign) {
                sign = -1;
                hasSign = true;
                continue;
            }
            if (s.charAt(i) == '+' && !hasSign) {
                sign = 1;
                hasSign = true;
                continue;
            }
            if (s.charAt(i) == ' ' && !hasSign) {
                continue;
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                hasSign = true;
                pop = s.charAt(i) - '0';
                if (ans * sign > Integer.MAX_VALUE / 10 || (ans * sign == Integer.MAX_VALUE / 10 && pop * sign > 7)) {
                    return Integer.MAX_VALUE;
                }
                if (ans * sign < Integer.MIN_VALUE / 10 || (ans * sign == Integer.MIN_VALUE / 10 && pop * sign < -8)) {
                    return Integer.MIN_VALUE;
                }
                ans = ans * 10 + pop;
            } else {
                return ans * sign;
            }
        }
        return ans * sign;
    }

    public int myAtoi2(String s) {
        Matcher matcher = PATTERN.matcher(s.trim());
        String result = "";
        if (matcher.find()) {
            result = s.trim().substring(matcher.start(), matcher.end());
        } else {
            return 0;
        }

        if (result.length() == 1 && (result.charAt(0) == '+' || result.charAt(0) == '-')) {
            return 0;
        }

        try {
            return Integer.parseInt(result);
        } catch (Exception e) {
            return result.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
