class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        int m = 100001;
        int[] losses = new int[m];

        for (int i = 0; i < n; i++) {
            int win = matches[i][0];
            int loss = matches[i][1];
            
            if (losses[win] == 0) {
                losses[win] = -1;
            }
            
            if (losses[loss] == -1) {
                losses[loss] = 1;
            } else {
                losses[loss]++;
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        
        for (int i = 0; i < m; i++) {
            if (losses[i] == -1) {
                res.get(0).add(i);
            } else if (losses[i] == 1) {
                res.get(1).add(i);
            }
        }
        
        return res;
    }
}