import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        int result = 0;
        
        for (int i : nums) {
            int temporary = frequency.getOrDefault(i, 0);
            result += temporary;
            frequency.put(i, temporary + 1);
        }
        
        return result;
    }
}