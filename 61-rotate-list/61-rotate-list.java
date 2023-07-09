class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int cnt = 1;
        ListNode tail = head;
        while (tail.next != null) {
            cnt++;
            tail = tail.next;
        }
        tail.next = head;
        int newHead = cnt - k % cnt;
        for (int i = 0; i < newHead; i++) tail = tail.next;
        head = tail.next;
        tail.next = null;
        return head;
    }
}