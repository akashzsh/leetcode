class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0], len = releaseTimes.length;
        char ans = keysPressed.charAt(0);
        for (int i = 1; i < len; i++) {
            int tmp = releaseTimes[i] - releaseTimes[i - 1];
            if (tmp > max) {
                max = tmp;
                ans = keysPressed.charAt(i);
            } else if (tmp == max) {
                ans = ans > keysPressed.charAt(i) ? ans : keysPressed.charAt(i);
            }
        }
        return ans;
    }
}