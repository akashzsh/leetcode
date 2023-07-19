class Solution {
    public int minDeletionSize(String[] strs) {
        int cols = strs[0].length(), cnt = 0, len = strs.length;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}