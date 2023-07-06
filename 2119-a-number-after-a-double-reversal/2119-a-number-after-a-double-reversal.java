class Solution {
    public int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            rev = (rev * 10) + (num % 10);
            num /= 10;
        }
        return rev;
    }
    
    public boolean isSameAfterReversals(int num) {
        return num == reverse(reverse(num));
    }
}