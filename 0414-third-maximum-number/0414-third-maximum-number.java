class Solution {
    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int i : nums) {
            if (i == firstMax || i == secondMax || i == thirdMax) continue;
            if (firstMax <= i) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = i;
            } else if (secondMax <= i) {
                thirdMax = secondMax;
                secondMax = i;
            } else if (thirdMax <= i) {
                thirdMax = i;
            }
        }
        if (thirdMax == Long.MIN_VALUE) return (int)(firstMax);
        return (int)(thirdMax);
    }
}