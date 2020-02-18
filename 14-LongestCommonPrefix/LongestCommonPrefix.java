import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";
        int index = 0;
        while (true) {
            try {
                if (isSameCharAtIndex(index, strs)) {
                    longestCommonPrefix += strs[0].charAt(index);
                    index++;
                } else {
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return longestCommonPrefix;
    }

    private static boolean isSameCharAtIndex(int index, String[] strs) {
        boolean isSameChar = true;
        char cmp = strs[0].charAt(index);
        for (String string : strs) {
            if (string.charAt(index) != cmp) {
                isSameChar = false;
            }
        }
        return isSameChar;
    }

    public static void main(String[] args) {
        String[] ex1 = new String[]{"flower", "flow", "flight"};
        System.out.println("ex1: " + longestCommonPrefix(ex1));
        String[] ex2 = new String[]{"dog", "racecar", "car"};
        System.out.println("ex2: " + longestCommonPrefix(ex2));
    }
}
