class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map.putIfAbsent(i - j, new PriorityQueue<>());
                map.get(i-j).add(mat[i][j]);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = map.get(i - j).poll();
            }
        }
        return mat;
    }
}