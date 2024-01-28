class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        
        int res = 0;
        for (int startCol = 0; startCol < cols; startCol++) {
            for (int j = startCol; j < cols; j++) {
                int sum = 0;
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int i = 0; i < rows; i++) {
                    sum += matrix[i][j] - (startCol > 0 ? matrix[i][startCol - 1] : 0);
                    if (map.containsKey(sum - target)) {
                        res += map.get(sum - target);
                    }
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return res;
    }
}