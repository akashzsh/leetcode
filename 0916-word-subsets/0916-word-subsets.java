class Solution {
    private int[] counter(String s) {
        int[] tmp = new int[26];
        for (char l : s.toCharArray()) tmp[l - 'a']++;
        return tmp;
    }
    
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int cnt[] = new int[26], i;
        for (String b : words2) {
            int[] tmp = counter(b);
            for (i = 0; i < 26; i++) {
                if (tmp[i] > cnt[i]) cnt[i] = tmp[i];
            }
        }
        for (String a : words1) {
            int[] tmp = counter(a);
            for (i = 0; i < 26; i++) {
                if (tmp[i] < cnt[i]) break;
            }
            if (i == 26) res.add(a);
        }
        return res;
    }
}