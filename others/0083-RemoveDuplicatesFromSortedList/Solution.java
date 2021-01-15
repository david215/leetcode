import java.util.StringJoiner;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        void append(int val) {
            ListNode ptr = this;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new ListNode(val);
        }

        @Override
        public String toString() {
            StringJoiner sj = new StringJoiner(" - ", "[", "]");
            ListNode ptr = this;
            while (ptr != null) {
                sj.add(String.valueOf(ptr.val));
                ptr = ptr.next;
            }
            return sj.toString();
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;
        while (ptr.next != null) {
            if (ptr.val == ptr.next.val) {
                ptr.next = ptr.next.next;
                continue;
            }
            ptr = ptr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.append(1);
        l1.append(1);
        l1.append(1);
        l1.append(2);

        ListNode l2 = new ListNode(1);
        l2.append(1);
        l2.append(2);
        l2.append(3);
        l2.append(3);

        System.out.println("expected: [1 - 2], actual: " + deleteDuplicates(l1));
        System.out.println("expected: [1 - 2 - 3], actual: " + deleteDuplicates(l2));
    }
}
