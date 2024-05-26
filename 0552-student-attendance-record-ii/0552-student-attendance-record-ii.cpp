/*
* author: akashzsh
* language: cpp
* created: 26-05-2024
*/

class Solution {
public:    
    int checkRecord(int n) {
        int M = int(1e9) + 7;
        
        vector<vector<vector<int>>> dp(n + 1, vector<vector<int>>(2, vector<int>(3)));
        
        // base case
        for (int ab = 0; ab < 2; ab++) {
            for (int cl = 0; cl < 3; cl++) {
                dp[0][ab][cl] = 1;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int ab = 1; ab >= 0; ab--) {
                for (int cl = 2; cl >= 0; cl--) {
                    int res = 0;
                    res = (res % M + dp[i - 1][ab][0] % M) % M;
                    if (ab + 1 < 2) {
                        res = (res % M + dp[i - 1][ab + 1][0] % M) % M;
                    }
                    if (cl + 1 < 3) {
                        res = (res % M + dp[i - 1][ab][cl + 1] % M) % M;
                    }

                    dp[i][ab][cl] = res % M;
                }
            }
        }
        
        return dp[n][0][0];
    }
};

/*
class Solution {
public:
    int f(int n, int ab, int cl, int& M, vector<vector<vector<int>>>& dp) {
        if (ab > 1 || cl > 2) {
            return 0;
        }
        
        if (n == 0) {
            return 1;
        }
        
        if (dp[n][ab][cl] != -1) {
            return dp[n][ab][cl];
        }
        
        int res = 0;
        
        // present (I'm present today so my absent record will be same and consecutive late will break and get 0)
        res = (res % M + f(n - 1, ab, 0, M, dp) % M) % M;
        // absent (I'm absent today so my absent count will increase and consecutive late will break and get 0)
        res = (res % M + f(n - 1, ab + 1, 0, M, dp) % M) % M;
        // late (I'm late today so my absent record will be same and consecutive late will increase)
        res = (res % M + f(n - 1, ab, cl + 1, M, dp) % M) % M;
        
        return dp[n][ab][cl] = res % M;
    }
    
    int checkRecord(int n) {
        int M = int(1e9) + 7;
        
        vector<vector<vector<int>>> dp(n + 1, vector<vector<int>>(2, vector<int>(3, -1)));
        
        return f(n, 0, 0, M, dp);
    }
};
*/

/*

Some points to remember

Being absent doesn't carry your consecutive late streak so it becomes zero

*/