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
    public boolean hasCycle(ListNode head) 
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
        return (slow!=null && fast!=null && slow==fast);
    }
}