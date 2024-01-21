class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = gas[0], totalCost = cost[0];
        
        for (int i = 1; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        if (totalGas < totalCost) {
            return -1;
        }
        
        int res = 0, cur = 0;
        
        for (int i = 0; i < n; i++) {
            cur += gas[i] - cost[i];
            
            if (cur < 0) {
                cur = 0;
                res = i + 1;
            }
        }
        return res;
    }
}