class Solution {
    
    public int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head, right = head;
        int count = countNodes(head), curr = 1;
        while (curr++ != k) left = left.next;
        curr = 1;
        while (curr++ != count - k + 1) right = right.next;
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}