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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode ret = new ListNode(0);
        ListNode ptr1 = ret, ptr2 = head;
        while (ptr2 != null) {            
            ListNode pre = null, min = ptr2, ptr = ptr2;
            while(ptr.next!=null) {
                if(ptr.next.val<min.val) {
                    min = ptr.next;
                    pre = ptr;
                }
                ptr = ptr.next;
            }
            if(pre!=null) pre.next = min.next;
            ptr1 = ptr1.next = min;
            if (min == ptr2) ptr2 = ptr2.next;
        }
        ptr1.next = null;
        return ret.next;
    }
}
