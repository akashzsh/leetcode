class Solution {
    public boolean ifEqual(String a, String b) {
        int[] arr = new int[26];
        for (char letter : a.toCharArray()) arr[letter - 'a']++;
        for (char letter : b.toCharArray()) arr[letter - 'a']++;
        for (int i = 0; i < 26; i++) if (arr[i] > 3) return true;
        return false;
    }
    
    public boolean ifNotEqual(String a, String b) {
        int first = -1, second = -1;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (first == -1) first = i;
                else if (second == -1) second = i;
                else if (first != -1 && second != -1) return false;
            }
        }
        if (first != -1 && second == -1) return false;
        return a.charAt(first) == b.charAt(second) && a.charAt(second) == b.charAt(first);
    }
    
    public boolean buddyStrings(String s, String goal) {
        int len1 = s.length(), len2 = goal.length();
        if (len1 != len2) return false;
        if (s.equals(goal)) return ifEqual(s, goal);
        else return ifNotEqual(s, goal);
    }
}