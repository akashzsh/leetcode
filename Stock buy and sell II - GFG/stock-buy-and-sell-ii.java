//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] prices = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        int[] prev = new int[2];
        prev[0] = prev[1] = 0;
        for (int day = n - 1; day >= 0; day--) {
            int[] curr = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                int profit;
                if (buy == 1) {
                    int get = -prices[day] + prev[0];
                    int notGet = 0 + prev[1];
                    profit = Math.max(get, notGet);
                } else {
                    int drop = prices[day] + prev[1];
                    int notDrop = 0 + prev[0];
                    profit = Math.max(drop, notDrop);
                }
                curr[buy] = profit;
            }
            prev = curr;
        }
        return prev[1];
    }
}