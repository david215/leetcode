class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return quickselect(nums, k, key=lambda n: -n)


def quickselect(l, k, key=lambda x: x):
    def helper(i, j, k, key):
        partition_index = partition(l, i, j, key)
        left_partition_size = partition_index - i + 1

        if k == left_partition_size:
            return max(l[i:i+k], key=key)
        elif k < left_partition_size:
            return helper(i, partition_index, k, key)
        else:  # k > left_partition_size
            return helper(partition_index + 1, j, k - left_partition_size, key)

    return helper(0, len(l) - 1, k, key)


def partition(l, lo, hi, key) -> int:
    random_pivot = random.randint(lo, hi)
    l[lo], l[random_pivot] = l[random_pivot], l[lo]

    pivot = lo
    i = lo - 1
    j = hi + 1
    while True:
        i += 1
        while key(l[i]) < key(l[pivot]):
            i += 1

        j -= 1
        while key(l[j]) > key(l[pivot]):
            j -= 1

        if i >= j:
            return j

        l[i], l[j] = l[j], l[i]


if __name__ == "__main__":
    s = Solution()

