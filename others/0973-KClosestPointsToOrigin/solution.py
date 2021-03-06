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


if __name__ == "__main__":
    s = Solution()

