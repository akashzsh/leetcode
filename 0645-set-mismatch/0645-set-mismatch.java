class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length, xor = 0;
        
        for (int i = 1; i <= n; i++) {
            xor ^= nums[i - 1];
            xor ^= i;
        }
        
        int bitNumber = 0;
        while ((xor & (1 << bitNumber)) == 0) {
            bitNumber++;
        }
        
        int zeroCrew = 0, oneCrew = 0;
        for (int i = 1; i <= n; i++) {
            if ((nums[i - 1] & (1 << bitNumber)) == 0) {
                zeroCrew ^= nums[i - 1];
            } else {
                oneCrew ^= nums[i - 1];
            }
            
            if ((i & (1 << bitNumber)) == 0) {
                zeroCrew ^= i;
            } else {
                oneCrew ^= i;
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == zeroCrew) {
                cnt++;
            }
        }
        
        if (cnt == 2) {
            return new int[]{zeroCrew, oneCrew};
        } else {
            return new int[]{oneCrew, zeroCrew};
        }
    }
}