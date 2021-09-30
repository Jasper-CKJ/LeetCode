/**
 * @author jasper
 * @create 2021-09-30 17:20
 */
public class Integer2Roman {

    public String getRoman(int num, int count) {
        char[] ten = {'I', 'X', 'C', 'M'};
        char[] five = {'V', 'L', 'D'};

        StringBuilder res = new StringBuilder();
        if (num <= 3) {
            while (num != 0) {
                res.append(ten[count]);
                num--;
            }
        } else if (num == 4) {
            res = new StringBuilder((ten[count] + "") + (five[count] + ""));
        } else if (num == 5) {
            res = new StringBuilder((five[count] + ""));
        } else if (num < 9) {
            res = new StringBuilder(five[count] + "");
            num -= 5;
            while (num != 0) {
                res.append(ten[count]);
                num--;
            }
        } else {
            res = new StringBuilder((ten[count] + "") + (ten[count + 1] + ""));
        }
        return res.toString();
    }

    /**
     * 时间复杂度：num 的位数 ,所以时间复杂度是 O（log（n））
     * 空间复杂度：常数个变量，O（1
     */
    public String intToRoman1(int num) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        while (num != 0) {
            int pop = num % 10;
            res.insert(0, getRoman(pop, count));
            count++;
            num /= 10;
        }
        return res.toString();
    }


    public String intToRoman2(int num) {
        // https://leetcode.com/problems/integer-to-roman/discuss/6310/My-java-solution-easy-to-understand
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public String intToRoman3(int num) {
        // https://leetcode.com/problems/integer-to-roman/discuss/6376/Simple-JAVA-solution
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}
