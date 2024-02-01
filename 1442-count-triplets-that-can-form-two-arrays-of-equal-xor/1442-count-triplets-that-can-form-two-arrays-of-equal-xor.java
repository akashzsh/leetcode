class Solution {
    public int countTriplets(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                xor ^= arr[k];
                if (xor == 0) {
                    res += (k - i);
                }
            }
        }
        return res;
    }
}