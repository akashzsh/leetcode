class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length, left = 0, right = 0, res = 0;
        while (++right < n) {
            if (colors.charAt(left) == colors.charAt(right)) {
                if (neededTime[left] < neededTime[right]) {
                    res += neededTime[left];
                } else {
                    res += neededTime[right];
                    continue;
                }
            }
            left = right;
        }
        return res;
    }
}