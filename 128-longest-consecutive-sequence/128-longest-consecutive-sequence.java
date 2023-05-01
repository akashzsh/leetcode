class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        int longestStreak = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int current = i;
                int currStreak = 1;
                while (set.contains(current + 1)) {
                    currStreak++;
                    current++;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        return longestStreak;
    }
}