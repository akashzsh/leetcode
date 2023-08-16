//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    static ArrayList <Integer> max_of_subarrays(int nums[], int n, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        res.add(nums[q.peekFirst()]);
        for (int i = k; i < n; i++) {
            if (q.peekFirst() == i - k) q.pollFirst();
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
            res.add(nums[q.peekFirst()]);
        }
        return res;
    }
}