class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0, j = n - 1, cnt = 0;
        while (i <= j) {
            if (people[j] + people[i] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
            cnt++;
        }
        return cnt;
    }
}