import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jasper
 * @create 2021-10-11 18:26
 */
public class LetterCombinationsOfaPhoneNumber {
    private final String[] digitLetter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * ["a","b",c] * ["d","e","f"]
     */
    public List<String> letterCombinations1(String digits) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            res = mul(res, getList(digits.charAt(i) - '0'));
        }
        return res;
    }

    public List<String> getList(int digit) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digitLetter[digit].length(); i++) {
            res.add(digitLetter[digit].charAt(i) + "");
        }
        return res;
    }

    public List<String> mul(List<String> l1, List<String> l2) {
        if (l1.size() != 0 && l2.size() == 0) {
            return l1;
        }
        if (l1.size() == 0 && l2.size() != 0) {
            return l2;
        }
        List<String> ans = new ArrayList<>();
        for (String value : l1) {
            for (String s : l2) {
                ans.add(value + s);
            }
        }
        return ans;
    }

    /**
     * 队列
     * 第 1 次 for 循环结束后变为 a, b, c；
     * 第 2 次 for 循环的第 1 次 while 循环 a 出队，分别加上 d e f 然后入队，就变成 b c ad ae af
     * 第 2 次 for 循环的第 2 次 while 循环 b 出队，分别加上 d e f 然后入队，就变成 c ad ae af bd be bf
     * 第 2 次 for 循环的第 3 次 while 循环 c 出队，分别加上 d e f 然后入队，就变成 ad ae af bd be bf cd ce cf
     */
    public List<String> letterCombinations2(String digits) {
        // https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue
        LinkedList<String> res = new LinkedList<>();
        if(digits.isEmpty()){
            return res;
        }
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char s : digitLetter[x].toCharArray()) {
                    res.add(t + s);
                }
            }
        }
        return res;
    }
}
