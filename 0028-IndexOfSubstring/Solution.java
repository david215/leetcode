public class IndexOfSubstring {
    public static int indexOfSubstring(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (stringStartsWithPrefix(haystack.substring(i), needle)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean stringStartsWithPrefix(String string, String prefix) {
        if (prefix.equals("")) {
            return true;
        } else if (string.charAt(0) != prefix.charAt(0)) {
            return false;
        } else {
            return stringStartsWithPrefix(string.substring(1), prefix.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println("Index of \"ll\" in \"hello\": " + indexOfSubstring("hello", "ll"));
        System.out.println("Index of \"bba\" in \"aaaaa\": " + indexOfSubstring("aaaaa", "bba"));
        System.out.println("Index of \"\" in \"\": " + indexOfSubstring("", ""));
    }
}
