//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
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
    
    public int longestPalinSubseq(String s)
    {
        String t = new StringBuilder(s).reverse().toString();
        return lcs(s, t);
    }
}