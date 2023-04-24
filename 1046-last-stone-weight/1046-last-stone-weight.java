class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        int first = stones.length - 2, second = stones.length - 1;
        Arrays.sort(stones);
        while (true) {
            if (stones[first] == stones[second]) stones[first] = stones[second] = -1;
            else {
                stones[second] = stones[second] - stones[first];
                stones[first] = -1;                
            }
            Arrays.sort(stones);
            if (stones[first] == -1 && stones[second] == -1) return 0;
            if (stones[first] == -1 && stones[second] != -1) return stones[second];
        }        
    }
}