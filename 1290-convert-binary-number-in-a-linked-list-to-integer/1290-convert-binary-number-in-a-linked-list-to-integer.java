/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count - 1;
    }
    
    public int getDecimalValue(ListNode head) {
        int count = countNodes(head), result = 0;
        while (head != null) {
            if (head.val != 0) result += (1 << count);
            count--;
            head = head.next;
        }
        return result;
    }
}