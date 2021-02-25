class Solution:

    def searchInsert(self, nums: List[int], target: int) -> int:
        i, j = 0, len(nums) - 1
        while i <= j:
            m = (i + j) // 2
            n = nums[m]
            if target < n:
                j = m - 1
            elif target > n:
                i = m + 1
            else:  # n == target
                return m
        return i


if __name__ == "__main__":
    s = Solution()

