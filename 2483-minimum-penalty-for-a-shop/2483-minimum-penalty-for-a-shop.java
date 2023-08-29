class Solution {
    public int bestClosingTime(String customers) {
        int idx = -1, cur = 0, max = 0, n = customers.length();
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') cur++;
            else cur--;
            if (cur > max) {
                max = cur;
                idx = i;
            }
        }
        return idx + 1;
    }
}