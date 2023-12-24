class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int v1 = 0, v2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') v1++;
                else v2++;
            } else {
                if (s.charAt(i) == '0') v1++;
                else v2++;
            }
        }
        return v1 < v2 ? v1 : v2;
    }
}