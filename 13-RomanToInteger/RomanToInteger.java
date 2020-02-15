public class RomanToInteger {
    public static int RomanToInteger(String s) {
        int value = 0;
        char prev = Character.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            switch (curr) {
                case 'I':
                    value += 1;
                    break;
                case 'V':
                    value += 5;
                    if (prev == 'I') { value -= 2; }
                    break;
                case 'X':
                    value += 10;
                    if (prev == 'I') { value -= 2; }
                    break;
                case 'L':
                    value += 50;
                    if (prev == 'X') { value -= 20; }
                    break;
                case 'C':
                    value += 100;
                    if (prev == 'X') { value -= 20; }
                    break;
                case 'D':
                    value += 500;
                    if (prev == 'C') { value -= 200; }
                    break;
                case 'M':
                    value += 1000;
                    if (prev == 'C') { value -= 200; }
                    break;
            }
            prev = curr;
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(RomanToInteger("III") + " = 3");
        System.out.println(RomanToInteger("IV") + " = 4");
        System.out.println(RomanToInteger("IX") + " = 9");
        System.out.println(RomanToInteger("LVIII") + " = 58");
        System.out.println(RomanToInteger("MCMXCIV") + " = 1994");
    }
}
