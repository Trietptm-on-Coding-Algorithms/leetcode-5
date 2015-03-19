/**
 * My solution to https://leetcode.com/submissions/detail/23453965/
 *
 * (Top 5% fastest among all Java submissions)
 *
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        int position = 1;
        ListNode node = head;
        ListNode previous = null;
        while (node != null && node.next != null)
        {
            position++;
            if (position > n)
            {
                return head;
            }
            if (position > m)
            {
                ListNode temp = node.next;

                node.next = node.next.next;

                if (previous != null)
                {
                    temp.next = previous.next;
                    previous.next = temp;
                }
                else
                {
                    temp.next = head;
                    head = temp;
                }
            }
            else
            {
                // next node
                previous = node;
                node = node.next;
            }
        }
        return head;
    }
}
