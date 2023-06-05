class Solution {
    
    public int getXDiff(int[] a, int[] b) {
        return a[0] - b[0];
    }
    
    public int getYDiff(int[] a, int[] b) {
        return a[1] - b[1];
    }
    
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX = getXDiff(coordinates[0], coordinates[1]);
        int deltaY = getYDiff(coordinates[0], coordinates[1]);
        for (int i = 2; i < coordinates.length; i++) {
            if (deltaY * getXDiff(coordinates[0], coordinates[i]) != deltaX * getYDiff(coordinates[0], coordinates[i])) return false;
        }
        return true;
    }
}