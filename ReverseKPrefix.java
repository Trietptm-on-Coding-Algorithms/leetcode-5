package leetcode;

public class Main {
    /**
     * Reverse the prefix of a linked list up to at most the kth node from the beginning
     *
     * For example, when k=5, list
     * head->1->2->3->4->... becomes
     * 4->3->2->1->head->...
     *
     * @param head  a linked list
     * @param k     the maximal size of the prefix to be reversed
     * @return      a list obtained by reversing the prefix
     */
    public static ListNode reverseKPrefix(ListNode head, int k) {
        if(head==null || k<=1) return head;
        ListNode ptr = head.next, ret = head;
        while(ptr!=null && --k>0) {
            ListNode next = ptr.next;
            ptr.next = ret;
            ret = ptr;
            ptr = next;
        }
        head.next = ptr;
        return ret;
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k<=1) return head;
        ListNode ret = new ListNode(0);
        ListNode ptr = ret;
        ret.next = head;
        int size = 0;
        for(ListNode p=head; p!=null; p=p.next, size++);
        int n = size/k;
        while (n-->0) {
            ListNode ptr2 = ptr.next;
            ptr.next = reverseKPrefix(ptr.next, k);
            ptr = ptr2;
        }
        return ret.next;
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)  return head;
        ListNode ret = new ListNode(0);
        ListNode ptr = ret;
        ret.next = head;
        while(ptr.next!=null && ptr.next.next!=null) {
            // pre-condition: ptr->node->next->...
            ListNode node = ptr.next;
            ListNode next = node.next;
            node.next = next.next;
            ptr.next = next;
            ptr.next.next = node;
            ptr = node;
            // post-condition: ...->next->node->...
            //                           (ptr)
        }
        return ret.next;
    }

    public static void main(String[] args) {

        //ListNode l2 = makeList(new int[]{});
        //List<ListNode> list = Arrays.asList(new ListNode[]{l1,l2});
        //for(int i=0; i<=8; i++) {
        ListNode list1 = LinkedListAlgorithms.makeList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        System.out.println(reverseKPrefix(list1,2));
        list1 = LinkedListAlgorithms.makeList(new int[]{1, 2});
        System.out.println(reverseKGroup(list1, 2));
        //}
    }
}


