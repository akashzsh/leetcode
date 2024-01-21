class Solution {
    public int minimumRounds(int[] tasks) {
        //   0 1 2 3 4 5 6 7 8 9
        //  [2,2,2,3,3,4,4,4,4,4]
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