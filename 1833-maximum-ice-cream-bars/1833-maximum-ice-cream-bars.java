class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0, cur = 0;
        for (int i : costs) {
            if (cur + i <= coins) {
                res++;
                cur += i;
            } else {
                break;
            }
        }
        return res;
    }
}