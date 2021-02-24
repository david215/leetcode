class Solution:

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        i, j = 0, m * n - 1
        while i <= j:
            mid = (i + j) // 2
            z = matrix[mid // n][mid % n]
            if target < z:
                j = mid - 1
            elif target > z:
                i = mid + 1
            else:  # target == z
                return True
        return False


if __name__ == "__main__":
    s = Solution()

