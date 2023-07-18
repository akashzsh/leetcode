class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length, cnt = 0;
        for (int i = 0; i < len; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) cnt++;
        }
        return cnt;
    }
}