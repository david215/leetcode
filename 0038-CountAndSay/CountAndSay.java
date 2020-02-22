public class CountAndSay {
    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countAndSayHelper(s);
        }
        return s;
    }

    private static String countAndSayHelper(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int startRepeatIndex = 0;
        while (startRepeatIndex < len) {
            char c = s.charAt(startRepeatIndex);
            int endRepeatIndex = startRepeatIndex + 1;
            while (endRepeatIndex < len && s.charAt(endRepeatIndex) == c) {
                endRepeatIndex++;
            }
            int repeatCount = endRepeatIndex - startRepeatIndex;
            startRepeatIndex = endRepeatIndex;
            sb.append(repeatCount);
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(1 + " ?= " + countAndSay(1));
        System.out.println(11 + " ?= " + countAndSay(2));
        System.out.println(21 + " ?= " + countAndSay(3));
        System.out.println(1211 + " ?= " + countAndSay(4));
        System.out.println(111221 + " ?= " + countAndSay(5));
        System.out.println(312211 + " ?= " + countAndSay(6));
        System.out.println(13112221 + " ?= " + countAndSay(7));
        System.out.println(1113213211 + " ?= " + countAndSay(8));
    }
}
