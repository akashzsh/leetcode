class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = 26;
        int[] v1 = new int[n];
        int[] v2 = new int[n];
        
        for (char ch : word1.toCharArray()) {
            v1[ch - 'a']++;
        }
        
        for (char ch : word2.toCharArray()) {
            v2[ch - 'a']++;
        }
        
        for (int i = 0; i < n; i++) {
            if (v1[i] == 0 && v2[i] == 0) {
                continue;
            }
            if (v1[i] == 0 || v2[i] == 0) {
                return false;
            }
        }
        
        Arrays.sort(v1);
        Arrays.sort(v2);
        
        for (int i = 0; i < n; i++) {
            if (v1[i] != v2[i]) {
                return false;
            }
        }
        
        return true;
    }
}