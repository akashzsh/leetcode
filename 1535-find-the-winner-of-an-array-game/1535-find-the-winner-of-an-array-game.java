class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int maxElement = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }
        int cur = arr[0], streak = 0;
        for (int i = 1; i < n; i++) {
            int opponent = arr[i];
            if (cur < opponent) {
                cur = opponent;
                streak = 1;
            } else {
                streak++;
            }
            if (streak == k || cur == maxElement) {
                return cur;
            }
        }
        return -1;
    }
}