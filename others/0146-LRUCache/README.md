[Problem](https://leetcode.com/problems/lru-cache/)

## Algorithm Classification
- Design
- Linked List
- Queue
- Map

## Take 1
- Approach
    - Use collections.OrderedDict to implement.

- Code
```python
class LRUCache:

    def __init__(self, capacity: int):
        self.d = collections.OrderedDict()
        self.capacity = capacity

    def get(self, key: int) -> int:
        if key not in self.d:
            return -1
        else:
            self.d.move_to_end(key)  # FIFO
            return self.d[key]

    def put(self, key: int, value: int) -> None:
        if key in self.d:
            self.d.move_to_end(key)
        elif len(self.d) == self.capacity:
            self.d.popitem(False)  # FIFO
        self.d[key] = value
```
- Time: O(1) for both get and put
- Space: O(C), where C := cache capacity
- Result: Accepted

## Take 2
- Approach
    - e.g. our cache is [3, 2, 1] where the leftmost entry is MRU and the
      rightmost entry is LRU.
        - If we perform a get operation on 2, the cache should now be modified
          to [2, 3, 1].
        - Using a doubly linked list, the swapping operation described above
          can easily be implemented to have O(1) time complexity, given the
          references to the nodes to be swapped.
        - Use a dictionary to map a key value to the reference of a Node!

- Code
```python
class LRUCache:

    def __init__(self, capacity: int):
        self.d = {}  # map key to DLQ node
        self.q = DLQ()
        self.cap = capacity

    def get(self, key: int) -> int:
        if key in self.d:
            node = self.d[key]
            self.q.mark_mru(node)
            return node.v
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.d:
            node = self.d[key]
            node.v = value
            self.q.mark_mru(node)
        else:
            if len(self.d) == self.cap:
                removed_node = self.q.pop()
                del self.d[removed_node.k]
            node = self.q.push(key, value)
            self.d[key] = node


class DLQ:
    """Doubly Linked Queue"""

    class Node:
        def __init__(self, k, v, p=None, n=None):
            self.k = k
            self.v = v
            self.p = p
            self.n = n

    def __init__(self):
        # sentinel.n = mru, sentinel.p = lru
        self.sentinel = DLQ.Node(k=None, v=None)
        self.sentinel.p = self.sentinel
        self.sentinel.n = self.sentinel

    def push(self, k, v) -> Node:
        """Add as MRU node and return the reference to it."""
        node = DLQ.Node(k, v, self.sentinel, self.sentinel.n)
        self.sentinel.n = node
        node.n.p = node
        return node

    def pop(self) -> Node:
        """
        Remove LRU node and return the reference to it.
        Assume non-empty queue, since pop is only called
        when capacity is reached, where capacity >= 1.
        """
        node = self.sentinel.p
        node.p.n = node.n
        self.sentinel.p = node.p
        return node

    def mark_mru(self, node) -> None:
        """Move the node up by rearranging links."""
        node.p.n = node.n
        node.n.p = node.p
        self.sentinel.n.p = node
        node.n = self.sentinel.n
        self.sentinel.n = node
        node.p = self.sentinel
```
- Time: O(1) for both get and put
- Space: O(C), where C := cache capacity
- Result: Accepted

