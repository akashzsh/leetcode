class Solution {
    private int solve(int dvd, int dvs) {
        while (dvd % dvs == 0) dvd /= dvs;
        return dvd;
    }
    
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        for (int i : new int[] {2, 3, 5}) {
            n = solve(n, i);
        }
        return n == 1;
    }
}