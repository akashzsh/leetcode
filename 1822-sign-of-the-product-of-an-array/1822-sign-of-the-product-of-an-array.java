class Solution {
    public int arraySign(int[] nums) {
        for (int i : nums) if (i == 0) return 0;
        int negatives = 0;
        for (int i : nums) if (i < 0) negatives++;
        if (negatives % 2 == 0) return 1;
        return -1;
    }
}