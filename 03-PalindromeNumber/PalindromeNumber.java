import java.util.*;

public class PalindromeNumber {
    public static boolean isPalindrome(int n) {
        if (n < 0) { return false; }
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();
        while (n != 0) {
            int digit = n % 10;
            stack.push(digit);
            queue.offer(digit);
            n /= 10;
        }
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.poll()) { return false; }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
