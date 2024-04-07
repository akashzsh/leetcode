class TrieNode {
    TrieNode[] links;

    TrieNode() {
        links = new TrieNode[2];
    }
}

class Solution {
    public void insert(int x, TrieNode node) {
        TrieNode cur = node;

        for (int i = 31; i >= 0; i--) {

            int bit = (x >> i) & 1;

            if (cur.links[bit] == null) {
                cur.links[bit] = new TrieNode();
            }

            cur = cur.links[bit];
        }
    }

    public int getMaximum(int y, TrieNode node) {
        TrieNode cur = node;

        int sum = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = (y >> i) & 1;

            if (cur.links[1 - bit] != null) {
                sum = sum | (1 << i);
                cur = cur.links[1 - bit];
            } else {
                cur = cur.links[bit];
            }

        }

        return sum;
    }
    
    public int findMaximumXOR(int[] nums) {
        TrieNode node = new TrieNode();
        
        for (int it : nums) {
            insert(it, node);
        }
        
        int res = 0;
        
        for (int it : nums) {
            res = Math.max(res, getMaximum(it, node));
        }
        
        return res;
    }
}