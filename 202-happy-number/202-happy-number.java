class Solution {
    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        int slow = n, fast = getSum(n);
        while (fast != 1 && slow != fast) {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        return fast == 1;
    }
}