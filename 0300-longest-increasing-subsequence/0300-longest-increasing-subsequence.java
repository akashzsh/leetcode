class Solution {
    private int lowerBound(ArrayList<Integer> tmp, int key) {
        int low = 0, high = tmp.size() - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (tmp.get(mid) == key) return mid;
            else if (tmp.get(mid) > key) high = mid - 1;
            else low = mid + 1;
        }
        return high + 1;
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > tmp.get(tmp.size() - 1)) {
                tmp.add(nums[i]);
                len++;
            } else {
                int lb = lowerBound(tmp, nums[i]);
                tmp.set(lb, nums[i]);
            }
        }
        return len;
    }
}