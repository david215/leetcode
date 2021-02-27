class Solution:

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def find_start(i, j) -> int:
            while i < j:
                m = (i + j) // 2
                if nums[m] < target:
                    if nums[m + 1] == target:  # m < j always true, so safe
                        return m + 1
                    else:
                        i = m + 1
                else:  # nums[m] == target; nums > target won't happen
                    if m == i:
                        return m
                    else:
                        j = m  # don't skip m, since m could be the start index
            return i

        def find_end(i, j) -> int:
            while i < j:
                m = (i + j + 1) // 2  # ceiling division, not floor division
                if nums[m] > target:
                    if nums[m - 1] == target:  # m > i always true, so safe
                        return m - 1
                    else:
                        j = m - 1
                else:  # nums[m] == target; nums < target won't happen
                    if m == j:
                        return m
                    else:
                        i = m  # don't skip m, since m could be the end index
            return i

        i, j = 0, len(nums) - 1
        while i <= j:
            m = (i + j) // 2
            n = nums[m]
            if n < target:
                i = m + 1
            elif n > target:
                j = m - 1
            else:
                return [find_start(i, m), find_end(m, j)]
        return [-1, -1]


if __name__ == "__main__":
    s = Solution()

