import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> positions = new HashMap<>();
        int[] numsCopy = new int[length];
        System.arraycopy(nums, 0, numsCopy, 0, length);
        Arrays.sort(numsCopy);
        for (int i = 0; i < length; i++) {
            if (!positions.containsKey(numsCopy[i])) positions.put(numsCopy[i], i);
        }
        for (int i = 0; i < length; i++) {
            if (positions.containsKey(nums[i])) nums[i] = positions.get(nums[i]);
        }
        return nums;
    }
}