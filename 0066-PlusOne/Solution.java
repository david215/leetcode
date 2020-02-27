import java.util.Arrays;

public class Solution {
    public static int[] plusOne(int[] digits) {
        // iterative solution
        // boolean oneMoreDigit = false;
        // int end = digits.length - 1;
        // digits[end]++;
        // for (int i = end; i >= 0; i--) {
        //     if (digits[i] == 10) {
        //         digits[i] = 0;
        //         if (i != 0) {
        //             digits[i - 1]++;
        //         } else {
        //             oneMoreDigit = true;
        //         }
        //     }
        // }
        // int len = end + 1;
        // int[] result;
        // if (oneMoreDigit) {
        //     result = new int[len + 1];
        //     result[0] = 1;
        //     System.arraycopy(digits, 0, result, 1, len);
        // } else {
        //     result = new int[len];
        //     System.arraycopy(digits, 0, result, 0, len);
        // }
        // return result;
        int end = digits.length - 1;
        digits[end]++;
        return carryOver(digits, end);
    }

    private static int[] carryOver(int[] digits, int index) {
        if (digits[index] != 10) {
            int length = digits.length;
            int[] result = new int[length];
            System.arraycopy(digits, 0, result, 0, length);
            return result;
        } else {
            digits[index] = 0;
            if (index == 0) {
                int length = digits.length;
                int[] result = new int[length + 1];
                result[0] = 1;
                System.arraycopy(digits, 0, result, 1, length);
                return result;
            } else {
                digits[index - 1]++;
                return carryOver(digits, index - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{0};
        int[] b = new int[]{1, 2, 3};
        int[] c = new int[]{9, 9, 9};
        int[] aPlusOne = plusOne(a);
        int[] bPlusOne = plusOne(b);
        int[] cPlusOne = plusOne(c);
        System.out.println("expected: [1], actual: " + Arrays.toString(aPlusOne));
        System.out.println("expected: [1, 2, 4], actual: " + Arrays.toString(bPlusOne));
        System.out.println("expected: [1, 0, 0, 0], actual: " + Arrays.toString(cPlusOne));
    }
}
