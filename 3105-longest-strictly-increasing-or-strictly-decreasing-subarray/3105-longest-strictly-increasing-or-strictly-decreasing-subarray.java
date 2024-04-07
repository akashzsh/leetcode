// better approach (solved after contest)

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int curLen = 1, res = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                curLen++;
                res = Math.max(res, curLen);
            } else {
                curLen = 1;
            }
        }
        
        curLen = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                curLen++;
                res = Math.max(res, curLen);
            } else {
                curLen = 1;
            }
        }
        
        return res;
    }
}

// Brute Force (solved in contest)

/*
class Solution {
    public boolean isValid(int[] nums, int start, int end) {
        boolean ck = true;
        
        for (int i = start + 1; i <= end; i++) {
            if (nums[i - 1] >= nums[i]) {
                ck = false;
                break;
            }
        }
        
        if (ck) {
            return true;
        }
        
        ck = true;
        
        for (int i = end - 1; i >= start; i--) {
            if (nums[i + 1] >= nums[i]) {
                ck = false;
                break;
            }
        }
        
        return ck;
    }
    
    public int longestMonotonicSubarray(int[] nums) {
        int res = 1;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (isValid(nums, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        
        return res;
    }
}
*/