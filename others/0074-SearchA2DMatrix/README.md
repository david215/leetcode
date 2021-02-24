[Problem](https://leetcode.com/problems/search-a-2d-matrix/)

## Algorithm Classification
- Binary Search

## Takeaways
- row index = i // n, col index = i % n, where n := number of columns.

## Take 1
- Approach
    - Standard binary search with index = (row_index * n) + col_index

![](img-1.jpg)
- Code
```python
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
```
- Time: O(log MN)
- Space: O(1)
- Result: Accepted

