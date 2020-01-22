class Solution {
    public int singleNumber(int[] nums) {
        int xorSum = Arrays.stream(nums).reduce(0, (x, y) -> x ^ y);
        for (int num : nums) { if ((xorSum ^ num) == 0) { return num; } }
        return -1;
    }
}
