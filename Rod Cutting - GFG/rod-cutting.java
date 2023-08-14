//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int val[], int n) {
        int[] prev = new int[n + 1];
		for (int i = 0; i <= n; i++) prev[i] = i * val[0];
		for (int index = 1; index < n; index++) {
			int[] curr = new int[n + 1];
			for (int target = 0; target <= n; target++) {
				int notTake = 0 + prev[target];
				int take = (int)(-1e9);
				int rodlength = index + 1;
				if (rodlength <= target) take = val[index] + curr[target - rodlength];
				curr[target] = Math.max(take, notTake);
			}
			prev = curr;
		}
		return prev[n];
    }
}