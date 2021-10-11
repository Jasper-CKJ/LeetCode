/**
 * @author jasper
 * @create 2021-09-30 17:53
 */
public class LongestCommonPrefix {
    /**
     * 垂直比较
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 水平比较
     */
    public String longestCommonPrefix2(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int minLen = Math.min(res.length(), strs[i].length());
            int j = 0;
            for (; j < minLen; j++) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
        }
        return res;
    }
}
