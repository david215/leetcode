import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') { stack.push(')'); }
            else if (c == '[') { stack.push(']'); }
            else if (c == '{') { stack.push('}'); }
            else if (stack.isEmpty() || c != stack.pop()) { return false; }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("(): " + isValid("()"));
        System.out.println("()[]{}: " + isValid("()[]{}"));
        System.out.println("(]: " + isValid("(]"));
    }
}
