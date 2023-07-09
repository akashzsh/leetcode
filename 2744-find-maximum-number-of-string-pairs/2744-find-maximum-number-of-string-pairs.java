class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            String rev = new StringBuilder(words[i]).reverse().toString();
            if (map.containsKey(rev)) {
                cnt++;
                map.put(rev, map.get(rev) - 1);
            }
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        return cnt;
    }
}