//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends

class Solution{
    int longestUniqueSubsttr(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, maxi = 0;
        for (int r = 0; r < n; r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }
            map.put(s.charAt(r), r);
            maxi = Math.max(maxi, r - l + 1);
        }
        return maxi;
    }
}