class Solution {
    public int minOperations(List<Integer> nums, int k) {
        HashSet<Integer> ref = new HashSet<>();
        HashSet<Integer> cal = new HashSet<>();
        for (int i = 1; i <= k; i++) ref.add(i);
        int i = nums.size() - 1;
        while (i >= 0) {
            cal.add(nums.get(i));
            if (cal.containsAll(ref)) return (nums.size() - i);
            i--;
        }
        return -1;
    }
}