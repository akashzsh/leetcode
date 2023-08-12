class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaOfA = (ay2 - ay1) * (ax2 - ax1);
        int areaOfB = (by2 - by1) * (bx2 - bx1);
        int totalArea = areaOfA + areaOfB;
        
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;
        
        int up = Math.min(ay2, by2);
        int down = Math.max(ay1, by1);
        int yOverlap = up - down;
        
        int toMinus = 0;
        if (xOverlap > 0 && yOverlap > 0) {
            toMinus = xOverlap * yOverlap;
        }
        
        return totalArea - toMinus;
    }
}