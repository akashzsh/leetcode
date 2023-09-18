//{ Driver Code Starts
#include<bits/stdc++.h>

using namespace std;


// } Driver Code Ends
class Solution{
    public:
    long long trappingWater(int arr[], int n){
        long long int leftMax = 0, rightMax = 0, ans = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            if (arr[i] <= arr[j]) {
                if (arr[i] > leftMax) leftMax = arr[i];
                else {
                    ans += leftMax - arr[i];
                }
                i++;
            } else {
                if (arr[j] > rightMax) rightMax = arr[j];
                else {
                    ans += rightMax - arr[j];
                }
                j--;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main(){
    
    int t;
    //testcases
    cin >> t;
    
    while(t--){
        int n;
        
        //size of array
        cin >> n;
        
        int a[n];
        
        //adding elements to the array
        for(int i =0;i<n;i++){
            cin >> a[i];            
        }
        Solution obj;
        //calling trappingWater() function
        cout << obj.trappingWater(a, n) << endl;
        
    }
    
    return 0;
}
// } Driver Code Ends