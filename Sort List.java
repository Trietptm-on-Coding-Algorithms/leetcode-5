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
public class Solution {

    int size (ListNode head) {
        int size = 0;
        while(head!=null) {
            head = head.next;
            size++;
        }
        return size;
    }
    ListNode merge (ListNode head1, ListNode head2) {        
        ListNode result = new ListNode (0);
        ListNode ptr = result;
        while(true) {
            if (head1==null) { 
                ptr.next = head2;
                break;
            }
            if (head2==null) { 
                ptr.next = head1;
                break;
            }
            if (head1.val<head2.val) {
                ptr.next = head1;
                head1 = head1.next;
            }
            else {
                ptr.next = head2;
                head2 = head2.next;
            }
            ptr = ptr.next;
        }        
        return result.next;
    }
    ListNode sortList (ListNode head) {
        if (head==null) return null;
        int middle = size(head)/2;
        if (middle==0) return head;
        ListNode head1 = head, pivot = head;
        int i = 0;
        while (++i<middle) pivot = pivot.next;
        ListNode head2 = pivot.next;
        pivot.next = null;
        head1 = sortList(head1);
        head2 = sortList(head2);
        return merge(head1, head2);
    }
    
}