package leetcode;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by ericpony on 2014/12/7.
 */

public class LinkedListAlgorithms {
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
        if (head == null || k <= 1) return head;
        ListNode ptr = head.next, ret = head;
        while (ptr != null && --k > 0) {
            ListNode next = ptr.next;
            ptr.next = ret;
            ret = ptr;
            ptr = next;
        }
        head.next = ptr;
        return ret;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode ret = new ListNode(0);
        ListNode ptr = ret;
        ret.next = head;
        int size = 0;
        for (ListNode p = head; p != null; p = p.next, size++) ;
        int n = size / k;
        while (n-- > 0) {
            ListNode ptr2 = ptr.next;
            ptr.next = reverseKPrefix(ptr.next, k);
            ptr = ptr2;
        }
        return ret.next;
    }
    /**
     * Merges two sorted linked list in O(n) time and O(1) auxiliary space.
     *
     * @param l1 a sorted linked list
     * @param l2 a sorted linked list
     * @return   a sorted list obtained by merging <code>l1</code> and <code>l2</code>
     * @see #mergeKLists
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(1), ret_ptr = ret;
        while (l1 != null && l2 != null) {
            boolean add_l1 = l1.val < l2.val;
            ret_ptr.next = add_l1 ? l1 : l2;
            ret_ptr = ret_ptr.next;
            l1 = add_l1 ? l1.next : l1;
            l2 = add_l1 ? l2 : l2.next;
        }
        if (l1 != null) ret_ptr.next = l1;
        if (l2 != null) ret_ptr.next = l2;
        return ret.next;
    }
    /**
     * Given two linked lists representing two non-negative numbers,
     * where the digits are stored in reverse order and each of their
     * nodes contain a single digit, this function adds the two numbers
     * and return it as a linked list in O(n) time. For example,
     * Input: (2 -> 4 -> 7) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 2 -> 1
     *
     * @param l1    a linked list representing a non-negative number
     * @param l2    a linked list representing a non-negative number
     * @return      a linked list representing the sum of input numbers
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode ret = new ListNode(0);
        ListNode ptr1 = l1, ptr2 = l2, ptr = ret;
        int carry = 0;
        ListNode loop = new ListNode(0);
        loop.next = loop;
        while (true) {
            int val = ptr1.val + ptr2.val + carry;
            if (val > 9) {
                val -= 10;
                carry = 1;
            } else
                carry = 0;
            ptr = ptr.next = new ListNode(val);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            if (ptr1 == null)
                if (ptr2 == loop)
                    break;
                else
                    ptr1 = loop;
            if (ptr2 == null)
                if (ptr1 == loop)
                    break;
                else
                    ptr2 = loop;
        }
        if (carry != 0)
            ptr.next = new ListNode(1);
        return ret.next;
    }
    /**
     * Given a linked list and a value x, partition it such that all nodes
     * less than x come before nodes greater than or equal to x.
     * <p />
     * The function preserves the original relative order of the nodes
     * in each of the two partitions. For example,
     * given 1->4->3->2->5->2 and x = 3, it returns 1->2->2->4->3->5.
     *
     * @param head  a linked list
     * @param x     a pivot to partition the list
     * @return      a partitioned list
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode left = new ListNode(0), ptr1 = left;
        ListNode right = new ListNode(0), ptr2 = right;
        while (head != null) {
            if (head.val < x)
                ptr1 = ptr1.next = head;
            else
                ptr2 = ptr2.next = head;
            head = head.next;
        }
        ptr1.next = right.next;
        ptr2.next = null;
        return left.next;
    }
    /**
     * Extracts the node with the minimal value from the linked list
     * <b>Remark</b> The returned node will be removed from the list.
     *
     * @param head  a linked list
     * @return      a node of the list with the minimal value
     */
    public static ListNode extractMinNode(ListNode head) {
        if(head==null) return null;
        ListNode pre = null, min = head;
        while(head.next!=null) {
            if(head.next.val<min.val) {
                min = head.next;
                pre = head;
            }
            head = head.next;
        }
        if(pre!=null) pre.next = min.next;
        min.next = null;
        return min;
    }

    /**
     * Insertion-sorts the linked list <code>head</code>
     *
     * @param head  a linked list
     * @return      a sorted linked list
     * @see #extractMinNode
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode ret = new ListNode(0);
        ListNode ptr1 = ret, ptr2 = head;
        while (ptr2 != null) {
            ListNode next = ptr2.next;
            ListNode node = extractMinNode(ptr2);
            ptr1 = ptr1.next = node;
            if (node == ptr2) ptr2 = next;
        }
        ptr1.next = null;
        return ret.next;
    }

    /**
     * Given a linked list, swap every two adjacent nodes and return its head
     * in O(1) auxiliary space and O(n) time.
     *
     * For example, given 1->2->3->4, this function returns the list as 2->1->4->3.
     *
     * @param head  a linked list
     * @return      a list obtained by swapping nodes of <code>head</code> in pairs
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = new ListNode(0);
        ListNode ptr = ret;
        ret.next = head;
        while (ptr.next != null && ptr.next.next != null) {
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
    /**
     * Insertion-sorts the linked list <code>head</code>
     *
     * @param head  a linked list
     * @return      a sorted linked list
     */
    public static ListNode insertionSortList_V2(ListNode head) {
        if (head == null) return null;
        ListNode ret = new ListNode(0);
        ListNode ptr1 = ret, ptr2 = head;
        while (ptr2 != null) {
            ListNode pre = null, min = ptr2, ptr = ptr2;
            while (ptr.next != null) {
                if (ptr.next.val < min.val) {
                    min = ptr.next;
                    pre = ptr;
                }
                ptr = ptr.next;
            }
            if (pre != null) pre.next = min.next;
            ptr1 = ptr1.next = min;
            if (min == ptr2) ptr2 = ptr2.next;
        }
        ptr1.next = null;
        return ret.next;
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode ret = new ListNode(0);
        ListNode ptr = head, ret_ptr = ret;
        while (ptr != null) {
            ListNode p = ptr.next;
            while (p != null && p.val == ptr.val) p = p.next;
            p = (p == ptr.next ? ptr : p);
            ret_ptr.next = p;
            if (p == ptr) {
                ret_ptr = ret_ptr.next;
                ptr = ptr.next;
            } else
                ptr = p;
        }
        return ret.next;
    }

    /**
     * Removes the nth node from the end of the given list.
     *
     * @param head a linked list
     * @param n    a non-negative integer
     * @return     a list obtained from removing the nth node from the end of <code>head</code>
     * @see #rotateRight
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) return head;
        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode ptr1 = ret, ptr2 = head;
        while (--n > 0 && ptr2 != null) ptr2 = ptr2.next;
        if (ptr2 == null) return head; // n is too large; remove nothing and return
        while (ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr1.next = ptr1.next.next;
        return ret.next;
    }

    /**
     * Rotates a linked list n steps to the right in cyclic ordering.
     * <p/>
     * Note that parameter <code>n</code> is not bounded, thus if we
     * use n instead of n % (size of list) for iteration, the order of
     * the running time may turn out exponential.
     *
     * @param head a linked list
     * @param n    a non-negative integer
     * @return     a list obtained by rotating <code>head</code> n steps to right
     */
    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) return head;
        ListNode ptr2 = head;
        int size = 0;
        while (ptr2 != null) {
            ptr2 = ptr2.next;
            size++;
        }
        n = n % size;
        if (n == 0) return head;
        ptr2 = head;
        while (++n < size) ptr2 = ptr2.next;
        ListNode ret = ptr2.next, ptr1 = ptr2;
        while (ptr2.next != null) ptr2 = ptr2.next;
        ptr1.next = null;
        ptr2.next = head;
        return ret;
    }

    /**
     * Merge k sorted linked list in O(nlgk) time and O(lgk) auxiliary space.
     *
     * @param lists a {@link List} of sorted linked list
     * @return      a sorted list obtained by merging all lists in <code>lists</code>
     * @see #mergeTwoLists
     * @see java.util.PriorityQueue
     */
    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        return o1.val - o2.val;
                    }
                }
        );
        for (ListNode list : lists) {
            if (list != null) pq.add(list);
        }
        ListNode ret = new ListNode(0), ptr = ret;
        while (pq.size() != 0) {
            ListNode node = pq.poll();
            ptr.next = node;
            ptr = ptr.next;
            if (pq.size() == 0)
                break;
            if (node.next != null)
                pq.add(node.next);
        }
        return ret.next;
    }

    public static ListNode makeList(int[] vals) {
        if (vals == null || vals.length == 0) return null;
        ListNode ret = new ListNode(vals[0]);
        ListNode ptr = ret;
        for (int i = 1; i < vals.length; i++) {
            ptr.next = new ListNode(vals[i]);
            ptr = ptr.next;
        }
        return ret;
    }
}
