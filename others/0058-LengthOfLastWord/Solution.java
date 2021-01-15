public class Solution {
    public static int lengthOfLastWord(String s) {
        int start = 0;
        int end = -1;
        boolean in = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (in && c == ' ') {
                end = i - 1;
                in = false;
            } else if (!in && c != ' ') {
                start = i;
                in = true;
            }
        }
        if (in) {
            end = s.length() - 1;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println("expected: 6, actual: " + lengthOfLastWord("hello world!"));
        System.out.println("expected: 2, actual: " + lengthOfLastWord("a bcd  ef   "));
        System.out.println("expected: 0, actual: " + lengthOfLastWord(""));
        System.out.println("expected: 0, actual: " + lengthOfLastWord(" "));
        System.out.println("expected: 1, actual: " + lengthOfLastWord("a"));
    }
}
