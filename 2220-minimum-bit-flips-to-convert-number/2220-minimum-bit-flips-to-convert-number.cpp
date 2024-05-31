class Solution {
public:
    int minBitFlips(int start, int goal) {
        int xr = start ^ goal;
        
        int res = 0;
        
        while (xr > 0) {
            xr = xr & (xr - 1);
            res++;
        }
        
        return res;
    }
};