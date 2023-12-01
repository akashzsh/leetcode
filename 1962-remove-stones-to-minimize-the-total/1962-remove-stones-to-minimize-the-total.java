class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
            pq.add(piles[i]);
        }
        for (int i = 1; i <= k; i++) {
              int curr = pq.peek();
              pq.poll();

              int remove = curr / 2;
              sum -= remove;

              int remaining = curr - remove;

              pq.add(remaining);
        }
        return sum;
    }
}