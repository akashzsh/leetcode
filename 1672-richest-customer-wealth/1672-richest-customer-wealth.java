class Solution {
    public int maximumWealth(int[][] accounts) {
        int maximum = -1;
        int sum = 0;
        
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            if (sum > maximum) maximum = sum;
            sum = 0;
        }
        
        return maximum;
    }
}