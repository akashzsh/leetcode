class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, total = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if ((j - i + 1) % 2 != 0) {
                    total += sum;
                }
            }
        }
        return total;
    }
}