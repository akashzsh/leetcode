class Solution {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        Arrays.sort(tasks);
        int cnt = 0;
        int left = 0, right = 0;
        while (right < n) {
            if (tasks[left] == tasks[right]) {
                right++;
            } else {
                if (right - left < 2) {
                    return -1;
                }
                cnt += Math.ceil((double)(right - left) / 3);
                left = right;
            }
        }
        if (right - left < 2) {
            return -1;
        }
        cnt += Math.ceil((double)(right - left) / 3);
        return cnt;
    }
}