class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int[] nums = new int[len];
        System.arraycopy(arr, 0, nums, 0, len);
        Arrays.sort(nums);
        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int i : nums) rank.putIfAbsent(i, rank.size() + 1);
        for (int i = 0; i < len; i++) nums[i] = rank.get(arr[i]);
        return nums;
    }
}