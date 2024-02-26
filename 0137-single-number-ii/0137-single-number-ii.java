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


/*
Approach 2 (Intuitive)

class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0, res = 0;
        for (int i = 0; i < 32; i++) {
            sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum++;
                }
            }
            sum = sum % 3;
            if (sum != 0) {
                res = res | (sum << i);
            }
        }
        return res;
    }
}

*/