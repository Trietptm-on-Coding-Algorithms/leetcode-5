/**
 * My solution to https://leetcode.com/submissions/detail/23454147/
 *
 * (Top 40% among all Java submissions. How can it be further improved?)
 */

/* Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * Given a linked list and a value x, partition it such that all nodes
     * less than x come before nodes greater than or equal to x.
     * <p />
     * The function preserves the original relative order of the nodes
     * in each of the two partitions. For example,
     * Given 1->4->3->2->5->2 and x = 3,
     * return 1->2->2->4->3->5.
     *
     * @param head  a linked list
     * @param x     a pivot to partition the list
     * @return      a partitioned list
     */
    public static ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode left = new ListNode(0), ptr1 = left;
        ListNode right = new ListNode(0), ptr2 = right;
        while(head!=null) {
            if(head.val<x)
                ptr1 = ptr1.next = head;
            else
                ptr2 = ptr2.next = head;
            head = head.next;
        }
        ptr1.next = right.next;
        ptr2.next = null;
        return left.next;
    }
}
