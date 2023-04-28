class Solution {
    public double myPow(double x, int n) {
        double answer = 1.0;
        long m = n;
        if (m < 0) m = -1 * m;
        while (m > 0) {
            if (m % 2 == 0) {
                x = x * x;
                m = m / 2;
            } else {
                answer = answer * x;
                m = m - 1;
            }
        }
        if (n < 0) answer = (double)(1.0) / (double)(answer);
        return answer;
    }
}