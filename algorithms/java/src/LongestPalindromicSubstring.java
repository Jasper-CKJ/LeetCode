/**
 * @author jasper
 * @create 2021-09-26 13:12
 */
public class LongestPalindromicSubstring {

    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 暴力，列举所有的子串，判断是否为回文串，保存最长的回文串
     * 时间复杂度：两层 for 循环 O（n²），for 循环里边判断是否为回文，O（n），所以时间复杂度为 O（n³）。
     * 空间复杂度：O（1），常数个变量
     */
    public String longestPalindrome1(String s) {
        int max = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    result = s.substring(i, j);
                    max = Math.max(max, result.length());
                }
            }
        }
        return result;
    }

    /**
     * 动态规划
     * p[i+1,j-1]是回文串，那么只要 p[i] == p[j] ，就可以确定 p[i,j] 也是回文串了
     * 时间复杂度：两层循环，O（n²）。
     * 空间复杂度：用二维数组 P 保存每个子串的情况，O（n²）
     */
    public String longestPalindrome2(String s) {
        int length = s.length();
        boolean[][] p = new boolean[length][length];
        int max = 0;
        String result = "";
        for (int len = 1; len <= length; len++) {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) {
                    break;
                }
                // 子串长度为1/2时，单独考虑
                p[start][end] = (len == 1 || len == 2 || p[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                if (p[start][end] && len > max) {
                    max = len;
                    result = s.substring(start, end + 1);
                }
            }
        }
        return result;
    }


    public int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * 拓展中心
     * 回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可
     * 时间复杂度：O（n²）
     * 空间复杂度：O（1）
     */
    public String longestPalindrome3(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }


    public String preProcess(String s) {
        int length = s.length();
        if (length == 0) {
            return "^$";
        }
        StringBuilder ret = new StringBuilder("^");
        for (int i = 0; i < length; i++) {
            ret.append("#").append(s.charAt(i));
        }
        ret.append("#$");
        return ret.toString();
    }

    /**
     * Manacher's Algorithm 马拉车算法
     * 在每个字符间插入"#"，并且为了使得扩展的过程中，到边界后自动结束，在两端分别插入 "^" 和 "$"
     * 参考链接：https://blog.crimx.com/2017/07/06/manachers-algorithm/
     * 时间复杂度：for 循环里边套了一层 while 循环，难道不是 O (n²)？不！其实是 O (n)。
     * while 循环访问 R 右边的数字用来扩展，也就是那些还未求出的节点，然后不断扩展，而期间访问的节点下次就不会再进入 while 了，
     * 可以利用对称得到自己的解，所以每个节点访问都是常数次，所以是 O (n)。
     * 空间复杂度：O（n）
     */
    public String longestPalindrome4(String s) {
        String newS = preProcess(s);
        int len = newS.length();
        int[] p = new int[len];
        int c = 0, r = 0;
        for (int i = 1; i < len - 1; i++) {
            int iMirror = 2 * c - i;
            if (r > i) {
                p[i] = Math.min(r - i, p[iMirror]);
            } else {
                p[i] = 0;
            }
            while (newS.charAt(i + 1 + p[i]) == newS.charAt(i - 1 - p[i])) {
                p[i]++;
            }
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }
        int max = 0;
        int centerIndex = 0;
        for (int i = 1; i < len - 1; i++) {
            if (p[i] > max) {
                max = p[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - max) / 2;
        return s.substring(start, start + max);
    }
}
