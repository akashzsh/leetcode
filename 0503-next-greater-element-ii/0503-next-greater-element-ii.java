class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(nums[n - 1]);
        for (int i = n + n - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) st.pop();
            nge[i % n] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i % n]);
        }
        return nge;
    }
}