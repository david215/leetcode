class Solution:

    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if m == n:
            return head

        sentinel = ListNode()
        sentinel.next = head

        curr = sentinel
        for _ in range(m - 1):
            curr = curr.next
        rev_head = curr
        curr = curr.next
        rev_tail = curr

        prev = None
        for _ in range(n - m):
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt

        rev_head.next = curr
        rev_tail.next = curr.next
        curr.next = prev

        return sentinel.next


if __name__ == "__main__":
    s = Solution()

