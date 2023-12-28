class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode front = cur.next;
            cur.next = prev;
            prev = cur;
            cur = front;
        }
        return prev;
    }
    
    public ListNode findKthNode(ListNode start, int k) {
        while (start != null && k > 1) {
            k--;
            start = start.next;
        }
        return start;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head, prevLast = null;
        while (cur != null) {
            ListNode kth = findKthNode(cur, k);
            if (kth == null) {
                if (prevLast != null) {
                    prevLast.next = cur;
                }
                break;
            }
            ListNode nextNode = kth.next;
            kth.next = null;
            
            reverse(cur);
            if (cur == head) {
                head = kth;
            } else {
                prevLast.next = kth;
            }
            
            prevLast = cur;
            cur = nextNode;
        }
        return head;
    }
}