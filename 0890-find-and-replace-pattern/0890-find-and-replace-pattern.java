class Solution {
    private int[] f(String s) {
        int n = s.length();
        int[] tmp = new int[n];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(s.charAt(i), map.size());
            tmp[i] = map.get(s.charAt(i));
        }
        return tmp;
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = f(pattern);
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (Arrays.equals(f(w), p)) res.add(w);
        }
        return res;
    }
}