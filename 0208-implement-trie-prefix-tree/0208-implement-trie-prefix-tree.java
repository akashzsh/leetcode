class Node {
    Node[] links;
    boolean done;
    
    Node() {
        links = new Node[26];
        done = false;
    }
}

class Trie {
    Node node;
    
    public Trie() {
        node = new Node();
    }
    
    public void insert(String word) {
        int N = word.length();
        
        Node cur = node;
        
        for (int i = 0; i < N; i++) {
            char ch = word.charAt(i);
            
            if (cur.links[ch - 'a'] == null) {
                cur.links[ch - 'a'] = new Node();
            }
            
            cur = cur.links[ch - 'a'];
        }
        
        cur.done = true;
    }
    
    public boolean search(String word) {
        int N = word.length();
        
        Node cur = node;
        
        for (int i = 0; i < N; i++) {
            char ch = word.charAt(i);
            
            if (cur.links[ch - 'a'] == null) {
                return false;
            }
            
            cur = cur.links[ch - 'a'];
        }
        
        return cur.done;
    }
    
    public boolean startsWith(String prefix) {
        int N = prefix.length();
        
        Node cur = node;
        
        for (int i = 0; i < N; i++) {
            char ch = prefix.charAt(i);
            
            if (cur.links[ch - 'a'] == null) {
                return false;
            }
            
            cur = cur.links[ch - 'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */