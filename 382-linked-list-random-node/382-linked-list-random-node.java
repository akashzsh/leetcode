class Solution {
    private ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int scope = 1, currentValue = 0;
        ListNode current = head;
        while (current != null) {
            if (Math.random() < 1.0 / scope) currentValue = current.val;
            scope += 1;
            current = current.next;
        }
        return currentValue;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */