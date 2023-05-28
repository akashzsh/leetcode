class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode();
        ListNode current = result;
        int sum = 0;
        while (head != null) {
            if (head.val == 0 && sum != 0) {
                current.next = new ListNode(sum);
                current = current.next;
                sum = 0;
            }
            sum += head.val;
            head = head.next;
        }
        return result.next;
    }
}