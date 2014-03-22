/**
*   This program is free software: you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation, either version 3 of the License, or
*   (at your option) any later version.
*
*   This program is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.
*
*   You should have received a copy of the GNU General Public License
*   along with this program.  If not, see <http://www.gnu.org/licenses/>.
**/

package leetcode;

import java.util.*;

/**
* Solution for http://oj.leetcode.com/problems/sort-list/
*
* @author ericpony
**/
public class Leetcode {
 
    class ListNode {
        int val = 0;
        ListNode next = null;
    }
    
    int size (ListNode head) {
        int size = 0;
        while(head!=null) {
            head = head.next;
            size++;
        }
        return size;
    }
    ListNode merge (ListNode head1, ListNode head2) {        
        ListNode result = new ListNode ();
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
    
    ListNode array2list (int[] array) {
        ListNode head = new ListNode();
        ListNode ptr = head;
        for (int i=0; i<array.length; i++) {
            ListNode node = new ListNode();
            node.val = array[i];
            ptr.next = node;
            ptr = node;
        }
        return head;
    }
    int[] list2array (ListNode list) {
        int[] array = new int[size(list)];
        ListNode ptr = list;
        for (int i=0; i<array.length; i++) {            
            array[i] = ptr.val;
            ptr = ptr.next;
        }
        return array;
    }
    
    void run() {
        int[] input = {11,25,8,0,0,20,25,18,5,13,1,3,9,2,4,5,8,2,1};
        int[] output = list2array(sortList(array2list(input)));
        for(int i=0; i<output.length; i++)
            System.out.print(output[i]+" ");        
    }
    public static void main(String[] args) {
        Leetcode test = new Leetcode();
        test.run();
    }
}