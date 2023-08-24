class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String cur = words[i];
            int curLen = cur.length();
            for (int j = 0; j < curLen; j++) {
                value[i] = value[i] | 1 << (cur.charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if ((value[i] & value[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}