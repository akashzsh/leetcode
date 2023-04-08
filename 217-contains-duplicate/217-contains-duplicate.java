import java.util.HashMap;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            if (count.containsKey(i)) return true;
            count.put(i, 1);
        }
        return false;
    }
}