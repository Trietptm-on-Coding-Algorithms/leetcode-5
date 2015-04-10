/**
 * Solution to https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
/**
 * Definition for singly-linked list.
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
    public ListNode detectCycle(ListNode head) 
    {
        if(head==null) return null;
        ListNode slow = head, fast = head;
        try{
            do {
                fast = fast.next;
                fast = fast.next;
                slow = slow.next;
            }while(fast!=null && fast!=slow);
        }catch(Exception e){}
        if(slow==null || fast==null || slow!=fast)
            return null;
        slow = head;
        while(slow!=fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode b_ptr  = headB;
        while(b_ptr.next!=null) b_ptr = b_ptr.next;
        b_ptr.next = headB;
        ListNode ret = detectCycle(headA);
        b_ptr.next = null;
        return ret;
    }
}
