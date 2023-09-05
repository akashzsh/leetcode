class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node p = head;
        while (p != null) {
            Node headNext = p.next;
            p.next = new Node(p.val);
            p.next.next = headNext;
            p = headNext;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;
        Node newHead = head.next;
        Node p1 = newHead;
        while (p1.next != null) {
            p.next = p.next.next;
            p = p.next;
            p1.next = p1.next.next;
            p1 = p1.next;
        }
        p.next = p.next.next;
        return newHead;
    }
}