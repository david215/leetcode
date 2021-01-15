import java.util.List;
import java.util.ArrayList;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1).max;
        /*
        iterative solution
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) { nums[i] += nums[i - 1]; }
            if (nums[i] > max) { max = nums[i]; }
        }
        return max;
        */
    }

    private static class Result {
        private int lmax;
        private int max;
        private int rmax;
        private int sum;

        private Result(int lmax, int max, int rmax, int sum) {
            this.lmax = lmax;
            this.max = max;
            this.rmax = rmax;
            this.sum = sum;
        }
    }

    private static Result helper(int[] nums, int start, int end) {
        if (start == end) {
            int num = nums[start];
            return new Result(num, num, num, num);
        } else {
            int mid = (start + end) / 2;
            Result left = helper(nums, start, mid);
            Result right = helper(nums, mid + 1, end);
            int lmax = Math.max(left.lmax, left.sum + right.lmax);
            int max = Math.max(left.max, Math.max(left.rmax + right.lmax, right.max));
            int rmax = Math.max(left.rmax + right.sum, right.rmax);
            int sum = left.sum + right.sum;
            return new Result(lmax, max, rmax, sum);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("expected: 6, actual: " + maxSubArray(nums));
    }
}
