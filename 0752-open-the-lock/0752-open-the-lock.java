class Solution {
    public void pushNeighbors(String s, Queue<String> q, HashSet<String> set) {
        
        StringBuilder string = new StringBuilder(s);
        
        for (int i = 0; i < 4; i++) {
            
            char ch = string.charAt(i);
            
            // increase
            char inc = ch == '9' ? '0' : (char)(ch + 1);
            string.setCharAt(i, inc);
            
            if (!set.contains(string.toString())) {
                set.add(string.toString());
                q.add(string.toString());
            }
            
            // decrease
            char dec = ch == '0' ? '9' : (char)(ch - 1);
            string.setCharAt(i, dec);
            
            if (!set.contains(string.toString())) {
                set.add(string.toString());
                q.add(string.toString());
            }
            
            string.setCharAt(i, ch);
        }
        
    }
    
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        
        for (String deadend : deadends) {
            set.add(deadend);
        }
        
        StringBuilder start = new StringBuilder("0000");
        
        if (set.contains(start.toString())) {
            return -1;
        }
        
        Queue<String> q = new LinkedList<>();
        q.add(start.toString());
        
        int level = 0;
        
        while (!q.isEmpty()) {
            int sz = q.size();
            
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                
                if (cur.equals(target)) {
                    return level;
                }
                
                pushNeighbors(cur, q, set);
                
            }
            
            level++;
        }
        
        return -1;
    }
}