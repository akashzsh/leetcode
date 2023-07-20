class Pair {
    String word;
    int lvl;
    Pair (String word, int lvl) {
        this.word = word;
        this.lvl = lvl;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for (String s : wordList) set.add(s);
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.peek().word;
            int lvl = q.peek().lvl;
            if (word.equals(endWord)) return lvl;
            q.poll();
            int len = word.length();
            for (int i = 0; i < len; i++) {
                for (char l = 'a'; l <= 'z'; l++) {
                    char[] replaced = word.toCharArray();
                    replaced[i] = l;
                    String tmp = new String(replaced);
                    if (set.contains(tmp)) {
                        q.offer(new Pair(tmp, lvl + 1));
                        set.remove(tmp);
                    }
                }
            }
        }
        return 0;
    }
}