class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] p = new int[102];
        for (List<Integer> list : nums) {
            p[list.get(0)]++;
            p[list.get(1) + 1]--;
        }
        int sum = 0, cnt = 0;
        for (int i = 1; i <= 100; i++) {
            sum += p[i];
            if (sum != 0) cnt++;
        }
        return cnt;
    }
}