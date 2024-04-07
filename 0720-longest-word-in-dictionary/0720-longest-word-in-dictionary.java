class TrieNode {
    TrieNode[] links;
    boolean end;

    TrieNode() {
        links = new TrieNode[26];
        end = false;
    }
}

class Solution {
    public void insertWord(String word, TrieNode node) {
        TrieNode cur = node;

        for (char ch : word.toCharArray()) {
            if (cur.links[ch - 'a'] == null) {
                cur.links[ch - 'a'] = new TrieNode();
            }
            cur = cur.links[ch - 'a'];
        }

        cur.end = true;
    }

    public boolean exists(String word, TrieNode node) {
        TrieNode cur = node;

        for (char ch : word.toCharArray()) {
            if (cur.links[ch - 'a'] == null) {
                return false;
            }
            cur = cur.links[ch - 'a'];

            if (!cur.end) {
                return false;
            }

        }

        return cur.end;
    }
    
    public String longestWord(String[] arr) {
        TrieNode node = new TrieNode();

        String res = "";

        for (String cur : arr) insertWord(cur, node);

        for (String cur : arr) {
            if (exists(cur, node)) {
                if (cur.length() > res.length()) {
                    res = cur;
                } else if (cur.length() == res.length()) {
                    res = cur.compareTo(res) < 0 ? cur : res;
                }
            } 
        }

        return res;
    }
}