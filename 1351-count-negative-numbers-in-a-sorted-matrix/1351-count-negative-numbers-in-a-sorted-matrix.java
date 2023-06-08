class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] currRow : grid) {
            int low = 0, high = currRow.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (currRow[mid] < 0) high = mid - 1;
                else low = mid + 1;
            }
            count += currRow.length - low;
        }
        return count;
    }
}