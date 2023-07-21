class Solution {
    HashMap<String, Integer> map;
    String b;
    List<List<String>> ans;
    
    public void dfs(String endWord, ArrayList<String> seq) {
        if (endWord.equals(b)) {
            ArrayList<String> tmp = new ArrayList<>(seq);
            Collections.reverse(tmp);
            ans.add(tmp);
            return;
        }
        int len = endWord.length();
        int steps = map.get(endWord);
        for (int i = 0; i < len; i++) {
            for (char l = 'a'; l <= 'z'; l++) {
                char[] replaced = endWord.toCharArray();
                replaced[i] = l;
                String txp = new String(replaced);
                if (map.containsKey(txp) && map.get(txp) + 1 == steps) {
                    seq.add(txp);
                    dfs(txp, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String s : wordList) set.add(s);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        b = beginWord;
        map = new HashMap<>();
        map.put(beginWord, 1);
        set.remove(beginWord);
        int len = beginWord.length();
        while (!q.isEmpty()) {
            String word = q.poll();
            int steps = map.get(word);
            if (word.equals(endWord)) break;
            for (int i = 0; i < len; i++) {
                for (char l = 'a'; l <= 'z'; l++) {
                    char[] replaced = word.toCharArray();
                    replaced[i] = l;
                    String txp = new String(replaced);
                    if (set.contains(txp)) {
                        q.offer(txp);
                        set.remove(txp);
                        map.put(txp, steps + 1);
                    }
                }
            }
        }
        ans = new ArrayList<>();
        if (map.containsKey(endWord)) {
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(endWord);
            dfs(endWord, tmp);
        }
        return ans;
    }
}