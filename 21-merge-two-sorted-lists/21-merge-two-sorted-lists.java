class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode result = new ListNode(0);
        ListNode point = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                point.next = list1;
                list1 = list1.next;
            } else {
                point.next = list2;
                list2 = list2.next;
            }
            point = point.next;
        }
        point.next = list1 == null ? list2 : list1;
        return result.next;
    }
}