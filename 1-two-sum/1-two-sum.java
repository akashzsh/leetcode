import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mapping = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mapping.containsKey(target - nums[i])) return new int[] {mapping.get(target - nums[i]), i};
            mapping.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}