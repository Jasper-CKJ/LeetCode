/**
 * @author jasper
 * @create 2021-09-30 17:40
 */
public class Roman2Integer {

    public int getValue(char c) {
        switch (c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
        throw new IllegalArgumentException("unsupported character");
    }

    public int romanToInt(String s) {
        int res = 0;
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int cur = getValue(s.charAt(i));
            int next = getValue(s.charAt(i + 1));
            if (cur < next) {
                res -= cur;
            } else {
                res += cur;
            }
        }
        return res += getValue(s.charAt(s.length() - 1));
    }
}
