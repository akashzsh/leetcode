class Solution {
    public static int lcs(String s, String t) {
		int len1 = s.length(), len2 = t.length(); 
		int[] prev = new int[len2 + 1];
		for (int index1 = 1; index1 <= len1; index1++) {
			int[] curr = new int[len2 + 1];
			for (int index2 = 1; index2 <= len2; index2++) {
				if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
					curr[index2] = 1 + prev[index2 - 1];
				}
				else curr[index2] = Math.max(prev[index2], curr[index2 - 1]);
			}
			prev = curr;
		}
		return prev[len2];
    }
    
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return lcs(s, t);
    }
}