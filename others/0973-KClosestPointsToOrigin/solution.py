class Solution:

    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        l = [(math.sqrt(math.pow(p[0], 2) + math.pow(p[1], 2)), p) for p in points]
        heapq.heapify(l)
        res = []
        for _ in range(K):
            _, p = heapq.heappop(l)
            res.append(p)
        return res


if __name__ == "__main__":
    s = Solution()

