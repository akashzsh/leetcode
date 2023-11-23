class Solution {
    private int getEquationValue(int[] p1, int[] p2, int[] p3) {
        int x1 = p1[0], x2 = p2[0], x3 = p3[0];
        int y1 = p1[1], y2 = p2[1], y3 = p3[1];
        
        return (y3 - y2) * (x2 - x1) - (y2 - y1) * (x3 - x2);
    }
    
    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (p, q) -> q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0]);
        
        LinkedList<int[]> lower = new LinkedList<>();
        LinkedList<int[]> upper = new LinkedList<>();
        
        for (int[] point : trees) {
            int l = lower.size(), u = upper.size();
            while (l >= 2 && getEquationValue(lower.get(l - 2), lower.get(l - 1), point) > 0) {
                l--;
                lower.pollLast();
            }
            while (u >= 2 && getEquationValue(upper.get(u - 2), upper.get(u - 1), point) < 0) {
                u--;
                upper.pollLast();
            }
            lower.offer(point);
            upper.offer(point);
        }
        
        HashSet<int[]> set = new HashSet<>(lower);
        set.addAll(upper);
        return set.toArray(new int[set.size()][2]);
    }
}