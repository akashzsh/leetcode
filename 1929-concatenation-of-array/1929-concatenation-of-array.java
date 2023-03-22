class Solution {
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        if (length == 0) return new int[0];
        int lengthOfResult = nums.length * 2;
        int[] resultArray = new int[lengthOfResult];
        int pointer = 0;

        for (int i = 0; i < lengthOfResult; i++) {
            resultArray[i] = nums[pointer++];
            if (pointer == length) pointer = 0;
        }

        return resultArray;
    }
}