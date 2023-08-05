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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
		for (int i : arr) sum += i;
		boolean[] prev = new boolean[sum + 1];
		prev[0] = true;
		if (arr[0] <= sum) prev[arr[0]] = true;
		for (int i = 1; i < n; i++) {
			boolean[] curr = new boolean[sum + 1];
			curr[0] = true;
			for (int j = 1; j <= sum; j++) {
				boolean notPick = prev[j];
				boolean pick = false;
				if (arr[i] <= j) pick = prev[j - arr[i]];
				curr[j] = pick | notPick;
			}
			prev = curr;
		}
		int min = (int)(1e9);
		for (int i = 0; i <= sum; i++) {
			if (prev[i] == false) continue;
			int sum1 = i;
			int sum2 = sum - i;
			min = Math.min(min, Math.abs(sum1 - sum2));
		}
		return min;
	} 
}
