class Solution {
    public int lower(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = {-1, -1};
        for (int i = 0; i < mat.length; i++) {
            Arrays.sort(mat[i]);
            int ones = mat[i].length - lower(mat[i]);
            if (ones > res[1]) {
                res[0] = i;
                res[1] = ones;
            }
        }
        return res;
    }
}