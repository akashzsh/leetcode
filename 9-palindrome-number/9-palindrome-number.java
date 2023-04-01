class Solution {
    public boolean isPalindrome(int x) {
        int copy = x, rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        if (copy == rev) return true;
        return false;
    }
}