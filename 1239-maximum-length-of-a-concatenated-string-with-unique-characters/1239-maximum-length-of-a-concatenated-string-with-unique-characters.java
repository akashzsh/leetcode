class Solution {
    private boolean hasDuplicate(String s, String t) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            if (freq[ch - 'a'] > 0) return true;
            freq[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            if (freq[ch - 'a'] > 0) return true;
        }
        return false;
    }
    
    private int solve(int i, List<String> arr, String temp, int n) {
        if (i >= n) {
            return temp.length();
        }
        
        int pick = 0, notPick = 0;
        if (hasDuplicate(arr.get(i), temp)) {
            notPick = solve(i + 1, arr, temp, n);
        } else {
            notPick = solve(i + 1, arr, temp, n);
            pick = solve(i + 1, arr, temp + arr.get(i), n);
        }
        return Math.max(pick, notPick);
    }
    
    public int maxLength(List<String> arr) {
        int n = arr.size();
        String temp = "";
        
        return solve(0, arr, temp, n);
    }
}