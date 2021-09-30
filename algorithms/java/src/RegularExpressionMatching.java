/**
 * @author jasper
 * @create 2021-09-30 16:30
 */
public class RegularExpressionMatching {
    /**
     * 递归
     */
    public boolean isMatch1(String s, String p) {
        if (p.isEmpty()){
            return s.isEmpty();
        }
        boolean match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        // 只有长度大于 2 的时候，才考虑 *
        if (p.length() >= 2 && p.charAt(1) == '*'){
            // pattern 直接跳过两个字符。表示 * 前边的字符出现 0 次
            // pattern 不变，例如 text = aa ，pattern = a*，第一个 a 匹配，然后 text 的第二个 a 接着和 pattern 的第一个 a 进行匹配。
            // 表示 * 用前一个字符替代。
            return (isMatch1(s,p.substring(2)) || (match && isMatch1(s.substring(1), p)));
        } else {
            return match && isMatch1(s.substring(1), p.substring(1));
        }
    }
}
