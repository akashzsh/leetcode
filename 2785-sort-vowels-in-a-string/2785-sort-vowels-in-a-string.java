class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    
    public String sortVowels(String s) {
        int n = s.length();
        int[] count = new int[101];
        
        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                count[s.charAt(i) - 'A']++;
            }
        }
        
        StringBuffer sb = new StringBuffer();
        String sorted = "AEIOUaeiou";
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (!isVowel(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                while (count[sorted.charAt(j) - 'A'] == 0) {
                    j++;
                }
                sb.append(sorted.charAt(j));
                count[sorted.charAt(j) - 'A']--;
            }
        }
        return sb.toString();
    }
}