class Solution {
    private int f(int cnt) {
        int i = 0, p = 0;
        while (cnt - i > 2) {
            i += 3;
            p++;
        };
        if (cnt - i == 1) {
            p--;
            i -= 3;
        }
        return (p + ((cnt - i) / 2));
    }
    
    public int minOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int cnt = 0;
        for (int cur : map.values()) {
            if (cur < 2) return -1;
            if (cur % 3 == 0) {
                cnt += (cur / 3);
            } else {
                cnt += f(cur);
            }
        }
        return cnt;
    }
}