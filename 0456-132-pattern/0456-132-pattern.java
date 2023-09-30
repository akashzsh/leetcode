class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, e = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < e) {
                return true;
            } else {
                while (!st.isEmpty() && nums[i] > st.peek()) {
                    e = st.pop();
                }
            }
            st.push(nums[i]);
        }
        return false;
    }
}