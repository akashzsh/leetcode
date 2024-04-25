class Solution {
    public int minBitFlips(int start, int goal) {
        int t = start ^ goal, cnt = 0;
        
        while (t != 0) {
            if (t % 2 != 0) cnt++;
            t >>= 1;
        }
        
        return cnt;
    }
}