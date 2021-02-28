class Solution:

    def __init__(self, w: List[int]):
        w_sum = sum(w)
        self.p_cumul = []
        w_cumul = 0
        for w_i in w:
            w_cumul += w_i
            self.p_cumul.append(w_cumul / w_sum)

    def pickIndex(self) -> int:
        r = random.uniform(0, 1)  # inclusive upper bound
        i, j = -1, len(self.p_cumul)
        while i + 1 < j:
            m = (i + j) // 2
            p_m = self.p_cumul[m]
            if r > p_m:
                i = m
            elif r < p_m:
                j = m
            else:  # r == p_m; highly unlikely
                return m
        return j


if __name__ == "__main__":
    s = Solution()

