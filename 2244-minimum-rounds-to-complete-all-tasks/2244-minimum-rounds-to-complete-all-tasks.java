class Solution {
    public int minimumRounds(int[] tasks) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : tasks) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int value : map.values()) {
            if (value < 2) {
                return -1;
            }
            cnt += Math.ceil((double)(value) / 3);
        }
        
        return cnt;
    }
}