class Pair {
    int x;
    int y;
    
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        int n = nums.size();
        q.offer(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int r = cur.x, c = cur.y;
            int m = nums.get(r).size();
            res.add(nums.get(r).get(c));
            if (r < n - 1 && c == 0) {
                q.offer(new Pair(r + 1, c));
            }
            if (c < m - 1) {
                q.offer(new Pair(r, c + 1));
            }
        }
        n = res.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}