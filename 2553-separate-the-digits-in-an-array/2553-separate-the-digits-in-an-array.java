class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i : nums) {
            ArrayList<Integer> txp = new ArrayList<>();
            while (i != 0) {
                txp.add(i % 10);
                i /= 10;
            }
            for (int j = txp.size() - 1; j >= 0; j--) res.add(txp.get(j));
        }
        int len = res.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) ans[i] = res.get(i);
        return ans;
    }
}