class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Character ch = nums[i].charAt(i);
            sb.append(ch == '1' ? '0' : '1');
        }
        return sb.toString();
    }
}