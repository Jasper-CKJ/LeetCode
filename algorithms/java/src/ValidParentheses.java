import java.util.Stack;

/**
 * @author jasper
 * @create 2021-10-12 13:34
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c){
                case '(':
                case '[':
                case '{':
                    brackets.push(c);
                    break;
                case ')':
                    if (!brackets.empty() && brackets.peek() == '('){
                        brackets.pop();
                    }else {
                        return false;
                    }
                    break;
                case ']':
                    if (!brackets.empty() && brackets.peek() == '['){
                        brackets.pop();
                    }else {
                        return false;
                    }
                    break;
                case '}':
                    if (!brackets.empty() && brackets.peek() == '{'){
                        brackets.pop();
                    }else {
                        return false;
                    }
                    break;
            }
        }
        return brackets.empty();
    }
}
