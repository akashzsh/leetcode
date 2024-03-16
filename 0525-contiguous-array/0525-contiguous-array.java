class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> track = new HashMap<>();
        
        track.put(0, -1);
        
        int cnt = 0, res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            cnt += (nums[i] == 0 ? -1 : 1);
            
            if (track.containsKey(cnt)) {
                res = Math.max(res, i - track.get(cnt));
            } else {
                track.put(cnt, i);
            }
        }
        
        return res;
    }
}