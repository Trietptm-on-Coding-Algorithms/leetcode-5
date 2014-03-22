/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    public ListNode detectCycle(ListNode head) 
    {
        ListNode slow = null, fast = null;
        try{
            slow = head.next;
            fast = slow.next;
            while(fast!=null && fast!=slow)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
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
}