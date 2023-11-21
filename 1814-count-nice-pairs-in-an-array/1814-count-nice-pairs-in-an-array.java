class Solution {
    private int rev(int n) {
        int ans = 0;
        while (n > 0) {
            ans = ans * 10 + (n % 10);
            n = n / 10;
        }
        return ans;
    }
    
    public int countNicePairs(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] - rev(nums[i]);
        }
        int cnt = 0, mod = 1_000_000_007;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            cnt = (cnt + map.getOrDefault(arr[i], 0)) % mod;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return cnt;
    }
}