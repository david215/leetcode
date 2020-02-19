import java.util.StringJoiner;

public class MergeTwoSortedLists {
    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public void addNewNode(int val) {
            ListNode pointer = this;
            while (pointer.next != null) { pointer = pointer.next; }
            pointer.next = new ListNode(val);
        }

        @Override
        public String toString() {
            StringJoiner sj = new StringJoiner(" - ", "[", "]");
            ListNode pointer = this;
            while (pointer != null) {
                sj.add(String.valueOf(pointer.val));
                pointer = pointer.next;
            }
            return sj.toString();
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else { // l1.val >= l2.val
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.addNewNode(2);
        l1.addNewNode(4);

        ListNode l2 = new ListNode(1);
        l2.addNewNode(3);
        l2.addNewNode(4);

        System.out.println(mergeTwoLists(l1, l2));
    }
}
