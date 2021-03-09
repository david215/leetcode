class Solution:

    def leastInterval(self, tasks: List[str], n: int) -> int:
        total_cnt = len(tasks)
        if n == 0:
            return total_cnt

        cnt = Counter(tasks)
        l = list(cnt.values())
        l.sort()

        max_cnt = l.pop()
        idle_time = n * (max_cnt - 1)  # e.g. A . . A . . A for max_cnt = 3 and n = 2
        while l and idle_time > 0:
            curr = l.pop()
            idle_time -= min(curr, (max_cnt - 1))  # e.g. A B . A B . A B
        idle_time = max(0, idle_time)  # idle time cannot be negative
        return total_cnt + idle_time


if __name__ == "__main__":
    s = Solution()

