class Solution {
    int[][] dp;
    
    private int dot(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }
        if (dp[i][j] != 0) return dp[i][j];
        int cur = nums1[i] * nums2[j] + dot(i + 1, j + 1, nums1, nums2);
        return dp[i][j] = Math.max(cur, Math.max(dot(i + 1, j, nums1, nums2), 
                                    dot(i, j + 1, nums1, nums2)));
    }
    
    public int maxDotProduct(int[] nums1, int[] nums2) {        
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for (int i : nums1) {
            firstMax = Math.max(i, firstMax);
            firstMin = Math.min(i, firstMin);
        }
        
        for (int i : nums2) {
            secondMax = Math.max(i, secondMax);
            secondMin = Math.min(i, secondMin);
        }
        
        if (firstMax < 0 && secondMin > 0) return firstMax * secondMin;
        if (firstMin > 0 && secondMax < 0) return firstMin * secondMax;
        
        dp = new int[nums1.length][nums2.length];
        return dot(0, 0, nums1, nums2);
    }
}