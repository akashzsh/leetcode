class Solution {
    public int mySqrt(int x) {
        double low = 0, high = x, epsilon = 1e-6;
        
        while (high - low > epsilon) {
            double mid = low + (high - low) / 2;
            double guess = mid * mid;
            
            if (guess == x) {
                return (int) mid;
            } else if (guess > x) {
                high = mid;
            } else {
                low = mid;
            }
        }
        
        return (int) (high);
    }
}