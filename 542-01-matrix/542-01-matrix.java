class Pair {
    int x;
    int y;
    int d;
    Pair (int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] v = new int[m][n];
        int[][] result = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    v[i][j] = 1;
                    q.offer(new Pair(i, j, 0));
                }
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int x = q.peek().x, y = q.peek().y, d = q.peek().d;
            q.poll();
            result[x][y] = d;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && v[nx][ny] == 0 && mat[nx][ny] != 0) {
                    v[nx][ny] = 1;
                    q.offer(new Pair(nx, ny, d + 1));
                }
            }
        }
        return result;
    }
}