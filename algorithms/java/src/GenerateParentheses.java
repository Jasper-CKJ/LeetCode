import java.util.ArrayList;
import java.util.List;

/**
 * @author jasper
 * @create 2021-10-12 13:50
 */
public class GenerateParentheses {
    /**
     * 我们不停的加左括号，其实如果左括号超过 n/2 的时候，它肯定不是合法序列了
     * 添加括号的过程中，如果右括号的总数量大于左括号的总数量了，后边不论再添加什么，它都不可能是合法序列了
     * 第 0 个位置一定会是左括号，然后接着添加左括号或右括号，过程中左括号数一定大于或等于右括号数，
     * 当第一次出现左括号数等于右括号数的时候，假如此时的位置是 c 。
     * 那么位置 1 到 c - 1 之间一定是合法序列，此外 c + 1 到最后的 2n -1 也是合法序列。
     * 最重要的是，每一个合法序列都会有这么一个数 c ，且唯一
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generateParenthesis(n - i - 1)) {
                    for (String right : generateParenthesis(i)) {
                        res.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return res;
    }
}
