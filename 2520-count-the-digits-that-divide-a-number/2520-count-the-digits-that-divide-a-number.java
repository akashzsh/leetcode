class Solution {
    public int countDigits(int num) {
        int rem, answer = 0, copy = num;
        while (num > 0) {
            rem = num % 10;
            if (copy % rem == 0) answer++;
            num /= 10;
        }
        return answer;
    }
}