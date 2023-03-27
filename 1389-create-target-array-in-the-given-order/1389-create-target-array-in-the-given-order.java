import java.util.ArrayList;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;        
        ArrayList<Integer> target = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            target.add(index[i], nums[i]);
        }        
        int[] result = target.stream().mapToInt(i -> i).toArray();        
        return result;
    }
}