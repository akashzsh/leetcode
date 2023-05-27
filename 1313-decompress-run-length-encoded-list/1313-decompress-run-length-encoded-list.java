class Solution {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0, j = 1; i < nums.length - 1 && j < nums.length; i += 2, j += 2) {
            for (int k = 0; k < nums[i]; k++) result.add(nums[j]);
        }
        int[] resultant = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultant[i] = result.get(i);
        }
        return resultant;
    }
}