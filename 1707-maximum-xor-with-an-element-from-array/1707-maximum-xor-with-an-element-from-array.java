class Tuple {
    int xi;
    int ai;
    int idx;
    
    Tuple (int xi, int ai, int idx) {
        this.xi = xi;
        this.ai = ai;
        this.idx = idx;
    }
}

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
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        TrieNode node = new TrieNode();
        int[] res = new int[queries.length];
        
        Arrays.sort(nums);
        
        Tuple[] ts = new Tuple[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            ts[i] = new Tuple(queries[i][0], queries[i][1], i);
        }
        
        Arrays.sort(ts, (a, b) -> a.ai - b.ai);
        
        for (int i = 0, j = 0; i < queries.length; i++) {
            
            while (j < nums.length && nums[j] <= ts[i].ai) {
                insert(nums[j], node);
                j++;
            }
            
            if (j == 0) {
                res[ts[i].idx] = -1;
            } else {
                res[ts[i].idx] = getMaximum(ts[i].xi, node);
            }
        }
        
        return res;
    }
}