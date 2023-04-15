class Solution {
    public int majorityElement(int[] nums) {
        int times = nums.length / 2, majority = -1;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            if (count.containsKey(i)) count.put(i, count.get(i) + 1);
            else count.put(i, 1);
        }
        for (int i : nums) {
            if (count.get(i) > times) {
                majority = i;
                break;
            }
        }
        return majority;
    }
}