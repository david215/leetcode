[Problem](https://leetcode.com/problems/add-two-numbers/)

## Algorithm Classification
- Linked List

## Takeaways
- Utilizing a sentinel node is generally a good idea, as it makes handling edge
  cases easier and reduces chance of bug.
    - e.g. by creating a sentinel and returning sentinel.next, we can avoid
      special handling of returning None when l1 and l2 are both None.

## Take 1
- Approach
    - While either l1 or l2 has remaining digits, find the sum the current
      digits, passing the carry over if the sum >= 10.
![](img-1.jpg)
- Code
```python
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
```
- Time: O(max(M, N))
    - M := length of l1 and N := length of l2.
- Space: O(1)
- Result: Accepted

