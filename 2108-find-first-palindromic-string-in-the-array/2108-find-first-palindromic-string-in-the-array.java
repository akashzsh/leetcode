class Solution {
    
    public boolean check(String s) {
        StringBuilder res = new StringBuilder(s);
        res.reverse();
        if (s.equals(res.toString())) return true;
        return false;
    }
    
    public String firstPalindrome(String[] words) {
        for (String word : words) if (check(word)) return word;
        return "";
    }
}