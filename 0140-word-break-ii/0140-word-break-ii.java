class Solution {
    public void f(int start, String s, Set<String> set, List<String> res, String cur, int n) {
        if (start == n) {
            cur = cur.stripTrailing();
            res.add(cur);
            return;
        }
        
        for (int end = start + 1; end <= n; end++) {
            String str = s.substring(start, end);
            if (set.contains(str)) {
                f(end, s, set, res, cur + str + " ", n);
            }
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> dictionary = new HashSet<>(wordDict);
        f(0, s, dictionary, res, "", s.length());
        return res;
    }
}