class Solution:

    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        sentinel = ListNode()
        ptr = sentinel
        carry = 0
        while l1 or l2:
            x, y = 0, 0
            if l1:
                x = l1.val
                l1 = l1.next
            if l2:
                y = l2.val
                l2 = l2.next
            sum_ = x + y + carry
            val = sum_ % 10
            carry = sum_ // 10
            ptr.next = ListNode(val)
            ptr = ptr.next
        if carry:
            ptr.next = ListNode(1)
        return sentinel.next


if __name__ == "__main__":
    s = Solution()

