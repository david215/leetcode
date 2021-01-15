import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class Solution {
    public static int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        return memoize(n, map);
        // iterative solution
        // if (n < 3) {
        //     return n;
        // }
        // int prev = 1;
        // int curr = 2;
        // for (int i = 2; i < n; i++) {
        //     int tmp = curr;
        //     curr += prev;
        //     prev = tmp;
        // }
        // return curr;
    }

    private static int memoize(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int val = memoize(n - 1, map) + memoize(n - 2, map);
            map.put(n, val);
            return val;
        }
    }

    public static void main(String[] args) {
        System.out.println("expected: 1, actual: " + climbStairs(1));
        System.out.println("expected: 2, actual: " + climbStairs(2));
        System.out.println("expected: 3, actual: " + climbStairs(3));
        System.out.println("expected: 5, actual: " + climbStairs(4));
        System.out.println("expected: 8, actual: " + climbStairs(5));
    }
}
