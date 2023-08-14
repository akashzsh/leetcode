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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int lps(String s, String t) {
        int r = s.length(), c = t.length();
        int[] prev = new int[c + 1];
        for (int i = 1; i <= r; i++) {
            int[] curr = new int[c + 1];
            for (int j = 1; j <= c; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }
        return prev[c];
    }
    
	public int minOperations(String str1, String str2) 
	{
	    return str1.length() + str2.length() - 2 * lps(str1, str2);
	} 
}