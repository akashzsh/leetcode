class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        HashMap<Character, Integer> location = new HashMap<>();
        for (int i = 0; i < n; i++) {
            location.put(s.charAt(i), i);
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, location.get(s.charAt(i)) - i - 1);
        }
        return res;
    }
}