class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i : nums) set.add(i);
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) res++;
            head = head.next;
        }
        return res;
    }
}