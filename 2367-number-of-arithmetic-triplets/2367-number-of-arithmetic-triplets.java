class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        HashMap<Integer, Boolean> el = new HashMap<>();
        for (int i : nums) el.put(i, true);
        for (int i : nums)
            if (el.containsKey(i + diff) && el.containsKey(i - diff)) count++;
        return count;
    }
}