import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int complementValue = target - value;
            if (valueToIndexMap.containsKey(complementValue)) {
                return new int[]{valueToIndexMap.get(complementValue), i};
            } else {
                valueToIndexMap.put(value, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] solutionIndices = twoSum(nums, target);
        System.out.println(Arrays.toString(solutionIndices));
    }
}
