class Solution {
    public int numberOfBeams(String[] bank) {
        int k = 0, ans = 0;
        int[] oneCount = new int[bank.length];
        for (String word : bank) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '1') oneCount[k]++;
            }
            if (oneCount[k] > 0) k++;
        }
        int m = 0, len = oneCount.length;
        while (m + 1 < len) {
            ans += oneCount[m] * oneCount[m + 1];
            m++;
        }
        return ans;
    }
}