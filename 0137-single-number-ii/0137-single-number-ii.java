// Less Intuitive but Optimal

class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        
        return ones;
    }
}

// Intuitive

/*
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        
        for (int i = 0, cnt = 0; i < 32; i++, cnt = 0) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (1 << i)) != 0) {
                    cnt++;
                }
            }
            if (cnt % 3 != 0) {
                res = res | (1 << i);
            }
        }
        
        return res;
    }
}
*/