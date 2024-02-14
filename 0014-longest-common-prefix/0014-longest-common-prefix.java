class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0], s2 = strs[strs.length - 1];
        int i = 0;
        short n1 = (short)s1.length(), n2 = (short)s2.length();
        
        while (i < n1 && i < n2) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            i++;
        }
        
        return s1.substring(0, i);
    }
}