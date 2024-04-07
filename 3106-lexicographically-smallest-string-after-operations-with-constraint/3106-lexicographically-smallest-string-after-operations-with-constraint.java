class Solution {
    public String getSmallestString(String str, int k) {
        char[] s = str.toCharArray();
        
        for (int i = 0; i < s.length && k >= 0; i++) {
            
            if (s[i] != 'a') {
                
                int dist = Math.min(Math.abs(s[i] - 'a'), 26 - Math.abs(s[i] - 'a'));
                
                if (k >= dist) {
                    s[i] = 'a';
                    k -= dist;
                } else {
                    s[i] = (char) (s[i] - k);
                    k -= dist;
                }
            }
    
        }
        
        return new String(s);
    }
}