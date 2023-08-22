class Solution {
    private int gcd(int a, int b) {
        int min = a < b ? a : b;
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) return i;
        }
        return 1;
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode p1 = head, p2 = head;
        p2 = p1.next;
        while (p2 != null) {
            int tmp = gcd(p1.val, p2.val);
            ListNode newNode = new ListNode(tmp);
            p1.next = newNode;
            newNode.next = p2;
            p1 = p2;
            p2 = p2.next;
        }
        return head;
    }
}