package leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public String toString() {
        return val + (next == null ? "" : "->" + next);
    }
}
