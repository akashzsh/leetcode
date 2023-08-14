//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int lps(String s, String t) {
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
    
    static int countMin(String str)
    {
        return str.length() - lps(str, new StringBuilder(str).reverse().toString());
    }
}