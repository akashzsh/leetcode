class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashSet<Character> letters = new HashSet<>();
        for (int i = 0; i < n; i++) {
            letters.add(s.charAt(i));
        }
        int ans = 0;
        for (char letter : letters) {
            int first = -1, last = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == letter) {
                    if (first == -1) {
                        first = i;
                    } else {
                        last = i;
                    }
                }
            }
            HashSet<Character> set = new HashSet<>();
            for (int middle = first + 1; middle <= last - 1; middle++) {
                set.add(s.charAt(middle));
            }
            ans += set.size();
        }
        return ans;
    }
}