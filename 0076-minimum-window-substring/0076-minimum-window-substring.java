class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if (t.length() > n) {
            return "";
        }
        
        int i = 0, j = 0, minWindowSize = Integer.MAX_VALUE, reqCnt = t.length(), start = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for (char ch : t.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        
        while (j < n) {
            char ch = s.charAt(j);
            if (freq.getOrDefault(ch, 0) > 0) {
                reqCnt--;
            }
            freq.put(ch, freq.getOrDefault(ch, 0) - 1);
            
            while (reqCnt == 0) {
                int curWindowSize = j - i + 1;
                if (curWindowSize < minWindowSize) {
                    minWindowSize = curWindowSize;
                    start = i;
                }
                
                freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
                if (freq.get(s.charAt(i)) > 0) {
                    reqCnt++;
                }
                
                i++;
            }
            
            j++;
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindowSize);
    }
}