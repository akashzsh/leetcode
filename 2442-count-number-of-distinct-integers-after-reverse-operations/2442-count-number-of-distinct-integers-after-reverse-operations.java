class Solution {
    public int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            rev = (rev * 10) + (num % 10);
            num /= 10;
        }
        return rev;
    }
    
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
            set.add(reverse(i));
        }
        return set.size();
    }
}