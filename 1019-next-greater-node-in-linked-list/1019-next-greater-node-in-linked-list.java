class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }
        int n = nodes.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nodes.get(stack.peek()) < nodes.get(i)) {
                result[stack.peek()] = nodes.get(i);
                stack.pop();
            }
            stack.add(i);
        }
        return result;
    }
}