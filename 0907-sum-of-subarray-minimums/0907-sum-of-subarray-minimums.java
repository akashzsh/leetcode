class Pair {
    int x;
    int y;
    
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int MOD = 1_000_000_007;
    
    public int sumSubarrayMins(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Pair> st1 = new Stack<>();
        Stack<Pair> st2 = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            while (!st1.isEmpty() && st1.peek().x > nums[i]) {
                cnt += st1.pop().y;
            }
            st1.push(new Pair(nums[i], cnt));
            left[i] = cnt;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 1;
            while (!st2.isEmpty() && st2.peek().x >= nums[i]) {
                cnt += st2.pop().y;
            }
            st2.push(new Pair(nums[i], cnt));
            right[i] = cnt;
        }
        
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (nums[i] * (long)(left[i] * right[i]) % MOD) % MOD) % MOD;
        }
        
        return (int) res;
    }
}