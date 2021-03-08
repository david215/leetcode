class Solution:

    def minRemoveToMakeValid(self, s: str) -> str:
        res = s[:]
        stack, l = [], []
        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
            elif c == ')':
                if stack:
                    stack.pop()
                else:
                    l.append(i)
        # In the end, the possible cases are:
        # 1. both stack and list are empty
        # 2. only the stack is empty
        # 3. only the list is empty
        # 4. both are not empty
        #
        # Note that we want to remove characters at greater indices first,
        # because given i, j where i < j, if  s[i] is removed before s[j],
        # then s[j] != modified_s[j]. So we should process these indices
        # in LIFO order, or just reverse order.
        #
        # Cases 1-3 are simple, but the last one needs a special attention.
        # Observe that the indices remaining in the stack must be greater than
        # those in the list because indices are inserted into the list only
        # when the stack is empty, meaning that the ones remaining in the stack
        # were pushed after a smaller index was inserted into the list, so we
        # need to process the indices in the stack first then process the list.
        for i in reversed(stack):
            res = res[:i] + res[i + 1:]
        for i in reversed(l):
            res = res[:i] + res[i + 1:]

        return res


if __name__ == "__main__":
    s = Solution()

