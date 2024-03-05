class Solution {
    public int minimumLength(String s) {
        int low = 0, high = s.length() - 1;
        int res = high + 1;
        
        while (low <= high) {
            
            // when we have only two chars left (aa)
            if (low + 1 == high && s.charAt(low) == s.charAt(high)) {
                return 0;
            }
            
            // when we have only one char left (a)
            if (low == high) {
                return 1;
            }
            
            if (s.charAt(low) != s.charAt(high)) {
                break;
            }
            char ch = s.charAt(low);
            while (low <= high && s.charAt(low) == ch) {
                low++;
            }
            
            while (low <= high && s.charAt(high) == ch) {
                high--;
            }
            
            res = Math.min(res, high - low + 1);
        }
        
        return res;
    }
}