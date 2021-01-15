public class Solution {
    public static String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        for (int i = 0; i < b.length(); i++) {
            boolean charA = a.charAt(a.length() - 1 - i) == '1';
            boolean charB = b.charAt(b.length() - 1 - i) == '1';
            char curr = charA ^ charB ^ carry ? '1' : '0';
            carry = (charA && charB) || (carry && (charA || charB));
            sb.append(curr);
        }
        for (int j = b.length(); j < a.length(); j++) {
            boolean charA = a.charAt(a.length() - 1 - j) == '1';
            char curr = charA ^ carry ? '1' : '0';
            carry = charA && carry;
            sb.append(curr);
        }
        if (carry) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println("expected: 100, actual: " + addBinary(a, b));
        a = "1";
        b = "11";
        System.out.println("expected: 100, actual: " + addBinary(a, b));
        a = "1010";
        b = "1011";
        System.out.println("expected: 10101, actual: " + addBinary(a, b));
    }
}
