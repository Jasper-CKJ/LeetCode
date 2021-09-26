import java.util.ArrayList;
import java.util.List;

/**
 * @author jasper
 * @create 2021-09-26 17:19
 */
public class ZigZagConversion {
    /**
     * 暴力
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    /**
     * 字符的规律
     * 时间复杂度：O（n），虽然是两层循环，但第二次循环每次加的是 cycleLen ，无非是把每个字符遍历了 1 次，所以两层循环内执行的次数肯定是字符串的长度。
     * 空间复杂度：O（n）
     */
    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder ret = new StringBuilder();
        int length = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < length; j += cycleLen) {
                ret.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < length) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }
}
