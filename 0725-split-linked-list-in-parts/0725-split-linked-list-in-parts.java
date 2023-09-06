class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode ans[] = new ListNode[k], p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int q = len / k, r = len % k;
        p = head;
        for (int i = 0; i < k; i++) {
            ListNode newHead = new ListNode(0), write = newHead;
            for (int j = 0; j < q + (i < r ? 1 : 0); j++) {
                write = write.next = new ListNode(p.val);
                if (p.next != null) p = p.next;
            }
            ans[i] = newHead.next;
        }
        return ans;
    }
}