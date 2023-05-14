class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int i : nums) if (i > max) max = i;
        int low = 1, high = max, answer = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2, currAns = 0;
            for (int i : nums) currAns += Math.ceil((double) i / (double) mid);
            if (currAns <= threshold) {
                answer = Math.min(answer, mid);
                high = mid - 1;
            } else low = mid + 1;
        }
        return answer;
    }
}