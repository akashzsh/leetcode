class Solution {
    public int[] shuffle(int[] nums, int n) {        
        int firstPointer = 0;
        int secondPointer = n;
        int[] resultArray = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) resultArray[i] = nums[firstPointer++];
            else resultArray[i] = nums[secondPointer++];
        }
        return resultArray;
    }
}