class Solution:

    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        def predicate(divisor: int) -> bool:
            return sum(ceil(n / divisor) for n in nums) <= threshold

        return self.lower_bound(nums, 1, max(nums), predicate)

    def lower_bound(self, l, i, j, predicate):
        while i < j:
            m = (i + j) // 2
            if predicate(divisor=m):
                j = m
            else:
                i = m + 1
        return i


if __name__ == "__main__":
    s = Solution()

