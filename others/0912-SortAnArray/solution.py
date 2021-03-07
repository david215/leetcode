class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        quicksort(nums)
        return nums


def quicksort(l, key=lambda x: x) -> None:
    def helper(i, j, key):
        if i >= j:
            return
        partition_index = partition(l, i, j, key)
        helper(i, partition_index, key)
        helper(partition_index + 1, j , key)

    helper(0, len(l) - 1, key)


def partition(l, lo, hi, key) -> int:
    def swap(i, j):
        l[i], l[j] = l[j], l[i]

    random_pivot = random.randint(lo, hi)
    swap(lo, random_pivot)

    pivot = lo
    pivot_val = key(l[pivot])
    i, j = lo - 1, hi + 1
    while True:
        i += 1
        while key(l[i]) < pivot_val:
            i += 1
        j -= 1
        while key(l[j]) > pivot_val:
            j -=  1
        if i >= j:
            return j
        else:
            swap(i, j)


if __name__ == "__main__":
    s = Solution()

