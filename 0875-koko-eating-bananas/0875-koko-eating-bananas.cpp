class Solution {
public:
    bool hours_taken(int speed, vector<int>& piles, int N, int h) {
        int hours = 0;
        for (int i = 0; i < N; i++) {
            hours = hours + ceil((double)piles[i] / (double)speed);
            
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
    
    int minEatingSpeed(vector<int>& piles, int h) {
        int low = 1, high = *max_element(piles.begin(), piles.end()), N = piles.size();
        
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            
            if (hours_taken(mid, piles, N, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
};