class Solution {
    // This is not a generalised GCD function. This version only works if first parameter is the minimum number.
    public int getGcd(int a, int b) {
        for (int i = a; i > 0; i--) {
            if (a % i == 0 && b % i == 0) return i;
        }
        return 1;
    }
    
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        return getGcd(min, max);
    }
}