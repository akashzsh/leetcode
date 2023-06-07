class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int low = 0, high = nums.length, middle = 0;
        for (int i : nums) {
            if (i < pivot) middle++;
            else if (i > pivot) high--;
        }
        int[] result = new int[nums.length];
        for (int i : nums) {
            if (i < pivot) result[low++] = i;
            else if (i == pivot) result[middle++] = i;
            else result[high++] = i;
        }
        return result;
    }
}