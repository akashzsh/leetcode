class Solution {
    public int maximumCount(int[] nums) {
        int negatives = 0, positives = 0, zeroes = 0;
        for (int i : nums) {
            if (i < 0) negatives++;
            else if (i == 0) zeroes++;
            else positives++;
        }
        return positives > negatives ? positives : negatives;
    }
}