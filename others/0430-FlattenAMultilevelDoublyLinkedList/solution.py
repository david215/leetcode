class Solution:

    def flatten(self, head: 'Node') -> 'Node':
        def dfs(prev: Node, curr: Node) -> Node:
            prev.next = curr
            curr.prev = prev

            tail = curr
            tmp = curr.next
            if curr.child:
                tail = dfs(curr, curr.child)
                curr.child = None
            if tmp:
                tail = dfs(tail, tmp)
            return tail

        if not head:
            return None

        sentinel = Node(None, None, None, None)
        dfs(sentinel, head)
        sentinel.next.prev = None

        return sentinel.next


if __name__ == "__main__":
    s = Solution()

