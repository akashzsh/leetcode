class TrieNode {
    TrieNode[] links;
    boolean endWord;
    
    TrieNode() {
        links = new TrieNode[26];
        endWord = false;
    }
}

class WordDictionary {
    TrieNode node;

    public WordDictionary() {
        node = new TrieNode();
    }
    
    public void addWord(String word) {
        int N = word.length();
        TrieNode cur = node;
        
        for (int i = 0; i < N; i++) {
            if (cur.links[word.charAt(i) - 'a'] == null) {
                cur.links[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.links[word.charAt(i) - 'a'];
        }
        
        cur.endWord = true;
    }
    
    public boolean search(String word) {
        return f(word, node, 0);
    }
    
    public boolean f(String word, TrieNode cur, int idx) {
        int N = word.length();
        
        if (idx == N) {
            return cur.endWord;
        }
        
        if (word.charAt(idx) != '.') {
            if (cur.links[word.charAt(idx) - 'a'] == null) {
                return false;
            }
            return f(word, cur.links[word.charAt(idx) - 'a'], idx + 1);
        } else {
            for (int j = 0; j < 26; j++) {
                if (cur.links[j] != null && f(word, cur.links[j], idx + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}