[Problem](https://leetcode.com/problems/k-closest-points-to-origin/)

## Algorithm Classification
- Heap
- Quickselect

## Takeaways
- heapify takes O(N) time vs. N heappush calls takes O(N log N) time.

## Take 1
- Approach
    - Use min heap with Euclidean distance of a point to the origin as key.

![](img-1.jpg)
- Code
```python
def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
    l = [(math.sqrt(math.pow(p[0], 2) + math.pow(p[1], 2)), p) for p in points]
    heapq.heapify(l)
    res = []
    for _ in range(K):
        _, p = heapq.heappop(l)
        res.append(p)
    return res
```
- Time: O(N + k log N)
    - O(N) for heapify.
    - O(k log N) for k heappop.
- Space: O(N)
    - O(N) for the heap.
- Result: Accepted

## Take 2
- Approach
    - Use variation of quickselect to partition K elements on the left.

- Code
```python
class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        partial_sort(points, K, key=lambda p: math.pow(p[0], 2) + math.pow(p[1], 2))
        return points[:K]


def partial_sort(l, k, key=lambda x: x):
    def helper(l, i, j, k, key):
        if i >= j:
            return

        partition_index = partition(l, i, j, key)

        left_length = partition_index - i + 1
        if k < left_length:
            helper(l, i, partition_index, k, key)
        elif k > left_length:
            helper(l, partition_index + 1, j, k - left_length, key)
        # if k == left_length, done

    return helper(l, 0, len(l) - 1, k, key)


def partition(l, lo, hi, key=lambda x: x) -> int:
    random_pivot = random.randrange(lo, hi)
    l[lo], l[random_pivot] = l[random_pivot], l[lo]

    pivot_index = lo
    i = lo - 1
    j = hi + 1
    while True:
        i += 1
        while key(l[i]) < key(l[pivot_index]):
            i += 1

        j -= 1
        while key(l[j]) > key(l[pivot_index]):
            j -= 1

        if i >= j:
            return j
        else:
            l[i], l[j] = l[j], l[i]
```
- Time: O(N), on average
    - Partitioning takes O(N) time where N is determined by the size of the
      partition.
    - On average, partition size is halved for each recursion:
    - Then we get N + N/2 + N/4 + ... = O(N)
- Space: O(log N), on average
    - Recursion depth is O(log N) if N is halved for each recursion.
- Result: Accepted

