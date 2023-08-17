//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long prices[], int N){
        int n = prices.length;
        long[] prev = new long[2];
        prev[0] = prev[1] = 0;
        for (int day = n - 1; day >= 0; day--) {
            long[] curr = new long[2];
            for (int buy = 0; buy <= 1; buy++)
                if (buy == 1) curr[buy] = Math.max(-prices[day] + prev[0], prev[1]);
                else curr[buy] = Math.max(prices[day] + prev[1], prev[0]);
            prev = curr;
        }
        return prev[1];
    }
}