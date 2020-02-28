public class Solution {
    public static int mySqrt(int x) {
        return helper(x, x, 0, x);
        // iterative
        // int r = x, min = 0, max = x;
        // while (true) {
        //     if ((long) r * (long) r == x) {
        //         return r;
        //     } else if ((long) r * (long) r > x) {
        //         max = r;
        //         r = (min + r) / 2;
        //     } else { // r < x /r
        //         if ((long) (r + 1) * (long) (r + 1) > x) {
        //             return r;
        //         } else {
        //             min = r;
        //             r = (r + max) / 2;
        //         }
        //     }
        // }
    }

    private static int helper(int x, int r, int min, int max) {
        if (r * r == x) {
            return r;
        } else if ((long) r * (long) r > x) {
            return helper(x, (r + min) / 2, min, r);
        } else { // if (r * r < x)
            if ((long) (r + 1) * (long) (r + 1) > x) {
                return r;
            } else if ((long) (r + 1) * (long) (r + 1) < x) {
                return helper(x, (r + max) / 2, r, max);
            } else {
                return r + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("expected: 2, actual: " + mySqrt(4));
        System.out.println("expected: 2, actual: " + mySqrt(8));
        System.out.println("expected: 1, actual: " + mySqrt(1));
        System.out.println("expected: 1, actual: " + mySqrt(1));
        System.out.println("expected: 46340, actual: " + mySqrt(Integer.MAX_VALUE));
    }
}
