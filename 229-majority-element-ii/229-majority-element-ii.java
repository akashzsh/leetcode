class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int c1 = 0, c2 = 0, e1 = Integer.MIN_VALUE, e2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (c1 == 0 && nums[i] != e2) {
                e1 = nums[i];
                c1++;
            } else if (c2 == 0 && nums[i] != e1) {
                e2 = nums[i];
                c2++;
            } else if (nums[i] == e1) c1++;
            else if (nums[i] == e2) c2++;
            else {
                c1--;
                c2--;
            }
        }
        c1 = 0; c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == e1) c1++;
            else if (nums[i] == e2) c2++;
        }
        int breaking = nums.length / 3;
        if (c1 > breaking) result.add(e1);
        if (c2 > breaking) result.add(e2);
        return result;
    }
}