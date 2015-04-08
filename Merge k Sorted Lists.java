/**
 * A solution to https://leetcode.com/problems/merge-k-sorted-lists/
 * that takes O(nlogn) time and O(n) auxiliary space.
 */
/** 
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) {
 *     val = x;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode mergeKLists(List<ListNode> lists) {
    if(lists.size()==0) return null;
    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
      new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
          return o1.val - o2.val;
        }
      }
    );
    for(ListNode list:lists) {
      if(list!=null) pq.add(list);
    }
    ListNode ret = new ListNode(0), ptr = ret;
    while(pq.size()!=0) {
      ListNode node = pq.poll();
      ptr.next = node;
      ptr = ptr.next;
      if(pq.size()==0) 
        break;
      if(node.next!=null) 
        pq.add(node.next);
    }
    return ret.next;
  }
}
