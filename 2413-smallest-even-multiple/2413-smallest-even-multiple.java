class Solution {
    public int smallestEvenMultiple(int n) {
        int min = 2;
        while (true) {
            if (min % 2 == 0 && min % n == 0) break;
            min++;
        }
        return min;
    }
}