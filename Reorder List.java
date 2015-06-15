/**
 * My solution to https://leetcode.com/problems/reorder-list/
 *
 * Definition for singly-linked list.
 * class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) {
 *     val = x;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  int size(ListNode head) {
     int _size = 0;
     while(head!=null) {
       head = head.next;
       _size = _size + 1;
     }
     return _size;
  }
	public void reorderList(ListNode head) {
     if(head==null || head.next==null)
       return;
     ListNode list1 = head;
     ListNode list2 = null;
     int thresh = size(head)/2;
     while (thresh-->0)
    	 list1 = list1.next;
     ListNode ptr = list1.next;
     list1.next = null; // disconnect list1 and list2
     while (ptr!=null) {
       // build list2 in reverse older
       ListNode node = ptr.next;
       ptr.next = list2;
       list2 = ptr;
       ptr = node;
     }
     list1 = head;
     // interleave list1 and list2
     while (list2!=null) {
       ListNode node1 = list1.next;
       ListNode node2 = list2.next;
       list1.next = list2;
       list2.next = node1;
       list2 = node2;
       list1 = node1;
     }
   }
}
