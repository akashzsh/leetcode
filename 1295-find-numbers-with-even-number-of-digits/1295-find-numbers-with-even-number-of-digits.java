class Solution {
    public boolean count(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n /= 10;
        }
        return cnt % 2 == 0;
    }
    
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for (int i : nums) if (count(i)) cnt++;
        return cnt;
    }
}