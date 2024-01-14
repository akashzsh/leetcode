class Solution {
    public boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
    
    public void generate(int idx, String s, ArrayList<String> vec, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(vec));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                vec.add(s.substring(idx, i + 1));
                generate(i + 1, s, vec, res);
                vec.remove(vec.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        generate(0, s, new ArrayList<>(), res);
        return res;
    }
}