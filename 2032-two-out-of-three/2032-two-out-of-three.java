class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        ArrayList<Integer> res = new ArrayList<>();
        int[][] cnt = new int[3][101];
        for (int i : nums1) cnt[0][i] = 1;
        for (int i : nums2) cnt[1][i] = 1;
        for (int i : nums3) cnt[2][i] = 1;
        for (int i = 1; i < 101; i++) {
            if (cnt[0][i] + cnt[1][i] + cnt[2][i] > 1) res.add(i);
        }
        return res;
    }
}