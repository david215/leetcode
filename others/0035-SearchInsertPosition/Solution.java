public class SearchInsertPosition {
    public static int searchInsertPosition(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 6};
        System.out.println("expected: 2, actual: " + searchInsertPosition(array, 5));
        System.out.println("expected: 1, actual: " + searchInsertPosition(array, 2));
        System.out.println("expected: 4, actual: " + searchInsertPosition(array, 7));
        System.out.println("expected: 0, actual: " + searchInsertPosition(array, 0));
    }

}
