import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jasper
 * @create 2021-09-24 17:02
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 暴力，用两个循环穷举所有子串
     * 时间复杂度：O（n³）
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    result = Math.max(result, j - i);
                }
            }
        }
        return result;
    }

    /**
     * 滑动窗口，
     * 时间复杂度：O（2n）
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int result = 0, i = 0, j = 0;
        while (i < n & j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

    /**
     * 滑动窗口优化，跳跃式窗口
     * 时间复杂度：O（n）
     * 空间复杂度：O(min（m，n))
     */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            result = Math.max(result, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return result;
    }

    /**
     * 滑动窗口优化，存储优化
     */
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length();
        int result = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            result = Math.max(result, j - i + 1);
            index[s.charAt(j)] = j + 1;
            //（下标 + 1） 代表 i 要移动的下个位置
        }
        return result;
    }
}
