class Solution {
    public long wonderfulSubstrings(String word) {
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0l, 1l);
        
        long result = 0;
        
        long xor = 0;
        
        for (char ch : word.toCharArray()) {
            
            int shift = ch - 'a';
            
            xor = xor ^ (1 << shift);
            
            // check for substrings with only even freq letters
            result += map.getOrDefault(xor, 0l);
            
            for (char x = 'a'; x <= 'j'; x++) {
                shift = x - 'a';
                
                // check for substrings with one odd number of letter
                result += map.getOrDefault(xor ^ (1 << shift), 0l);
            }
            
            map.put(xor, map.getOrDefault(xor, 0l) + 1);
        }
        
        return result;
    }
}