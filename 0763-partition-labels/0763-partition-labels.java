class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        ArrayList<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < n; i++) last[s.charAt(i) - 'a'] = i;
        int anchor = 0, j = 0;
        for (int i = 0; i < n; i++) {
            j = Math.max(j, last[s.charAt(i) - 'a']);
            if (i == j) {
                res.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return res;
    }
}