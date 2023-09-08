class Solution {
    private int dfs(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (nums[i] == 0) continue;
            sum++;
            nums[i]--;
            sum += dfs(nums);
            nums[i]++;
        }
        return sum;
    }
    
    public int numTilePossibilities(String tiles) {
        int[] nums = new int[26];
        for (char ch : tiles.toCharArray()) nums[ch - 'A']++;
        return dfs(nums);
    }
}