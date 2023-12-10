//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int k = sc.nextInt();
      Solution obj = new Solution();
      double ans = obj.findSmallestMaxDist(a,k);
      System.out.printf("%.2f",ans);
      System.out.println();
    }
  }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    private static double f(int[] arr, double distance) {
        int required = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            double cur = (arr[i + 1] - arr[i]) / distance;
            if ((arr[i + 1] - arr[i]) / distance == cur * distance) {
                cur--;
            }
            required += cur;
        }
        return required;
    }
    
  public static double findSmallestMaxDist(int arr[],int k) {
      double low = 0, high = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }
        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            if (f(arr, mid) > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return Math.round(high * 100.0) / 100.0;
  }
}
     