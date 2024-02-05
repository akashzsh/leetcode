class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nge = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        int n = nums2.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= nums2[i]) {
                stk.pop();
            }
            if (i < n) {
                if (!stk.isEmpty()) {
                    nge.put(nums2[i], stk.peek());
                } else {
                    nge.put(nums2[i], -1);
                }
            }
            stk.push(nums2[i]);
        }
        n = nums1.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nge.get(nums1[i]);
        }
        return res;
    }
}