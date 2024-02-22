class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] mark = new int[2001];
        
        for (int i = 0; i < trust.length; i++) {
            mark[trust[i][0]] = 1;
            mark[1000 + trust[i][1]]++;
        }
        
        for (int i = 1; i <= 1000; i++) {
            if (mark[i] == 0 && mark[1000 + i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}