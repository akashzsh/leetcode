class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n + 1];
        int e2, e3, e5;
        
        e2 = e3 = e5 = 1;
        
        nums[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int i2 = nums[e2] * 2;
            int i3 = nums[e3] * 3;
            int i5 = nums[e5] * 5;
            int min = Math.min(i2, Math.min(i3, i5));
            nums[i] = min;
            
            if (min == i2) e2++;
            if (min == i3) e3++;
            if (min == i5) e5++;
        }
        
        return nums[n];
    }
}