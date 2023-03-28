import java.util.Arrays;

class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        Arrays.fill(result, 0);
        for (int i = 0; i < queries.length; i++) {
            int xCenter = queries[i][0], yCenter = queries[i][1], radius = queries[i][2];
            for (int j = 0; j < points.length; j++) {
                if (((points[j][0] - xCenter) * (points[j][0] - xCenter)) + ((points[j][1] - yCenter) * (points[j][1] - yCenter)) <= radius * radius) {
                    result[i] += 1;
                }
            }
        }
        return result;
    }
}