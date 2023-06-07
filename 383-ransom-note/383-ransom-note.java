class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabets = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            alphabets[magazine.charAt(i) - 97]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int curr = ransomNote.charAt(i) - 97; 
            if (alphabets[curr] < 1) return false;
            alphabets[curr]--;
        }
        return true;
    }
}