class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode left = list1, right = list1, current = list2;
        int leftPos = 0, rightPos = 0;
        while (leftPos + 1 != a) {
            left = left.next;
            leftPos++;
        }
        while (rightPos != b) {
            right = right.next;
            rightPos++;
        }
        left.next = current;
        while (current.next != null) current = current.next;
        current.next = right.next;
        return list1;
    }
}