class Solution:

    def decodeString(self, s: str) -> str:
        stack = []

        for c in s:
            if c == ']':
                sub = ""
                while stack[-1] != '[':
                    sub = stack.pop() + sub
                stack.pop()  # discard '['

                n = ''
                while stack and stack[-1].isdigit():
                    n = stack.pop() + n
                n = int(n)
                sub *= n

                for sc in sub:
                    stack.append(sc)
            else:
                stack.append(c)

        return ''.join(stack)


if __name__ == "__main__":
    s = Solution()

