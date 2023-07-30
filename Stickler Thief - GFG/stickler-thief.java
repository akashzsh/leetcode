//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    public int FindMaxSum(int arr[], int n)
    {
        int len = arr.length;
        int prev = arr[0], prev1 = 0, curr;
        for (int i = 1; i < len; i++) {
            int pick = arr[i];
            if (i > 1) pick += prev1;
            int notPick = 0 + prev;
            curr = Math.max(pick, notPick);
            prev1 = prev;
            prev = curr;
        }
        return prev;
    }
}