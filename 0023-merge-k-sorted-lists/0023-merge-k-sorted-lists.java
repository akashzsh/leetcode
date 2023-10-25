class Solution {
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
    
    private ListNode solve(ListNode[] lists, int n, int low, int high) {
        if (low == high) {
            return lists[low];
        }
        
        int mid = low + ((high - low) >> 1);
        
        ListNode p1 = solve(lists, n, low, mid);
        ListNode p2 = solve(lists, n, mid + 1, high);
        
        return merge(p1, p2);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return solve(lists, lists.length, 0, lists.length - 1);
    }
}