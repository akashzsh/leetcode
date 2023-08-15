class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] tmp = new int[10000];
        for (int i : nums) {
            tmp[i]++;
            if (tmp[i] > 1) return i;
        }
        return -1;
    }
}