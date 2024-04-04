// Tabulation [Accepted] (binary search to search critical floor)

class Solution {
    public int superEggDrop(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];
        
        for (int e = 1; e <= eggs; e++) {
            dp[e][0] = 0;
            dp[e][1] = 1;
        }
        
        for (int f = 1; f <= floors; f++) {
            dp[1][f] = f;
        }
        
        for (int e = 2; e <= eggs; e++) {
            for (int f = 2; f <= floors; f++) {
                int res = 1_000_000_000, low = 1, high = f;
                
                while (low <= high) {
                    int cur = low + ((high - low) >> 1);
                    int up = dp[e][f - cur];
                    int down = dp[e - 1][cur - 1];
                    
                    int ans = 1 + Math.max(up, down);
                    
                    if (up < down) {
                        high = cur - 1;
                    } else {
                        low = cur + 1;
                    }
                    
                    res = Math.min(res, ans);
                }

                dp[e][f] = res;
            }
        }
        
        return dp[eggs][floors];
    }
}

// Tabulation (TLE)

/*
class Solution {
    public int superEggDrop(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];
        
        for (int e = 1; e <= eggs; e++) {
            dp[e][0] = 0;
            dp[e][1] = 1;
        }
        
        for (int f = 1; f <= floors; f++) {
            dp[1][f] = f;
        }
        
        for (int e = 2; e <= eggs; e++) {
            for (int f = 2; f <= floors; f++) {
                int res = 1_000_000_000;
        
                for (int cur = 1; cur <= f; cur++) {
                    res = Math.min(res, 1 + Math.max(dp[e][f - cur], dp[e - 1][cur -1]));
                }

                dp[e][f] = res;
            }
        }
        
        return dp[eggs][floors];
    }
}
*/

// Memoization (TLE)

/*
class Solution {
    public int f(int e, int f, int[][] dp) {
        if (f == 0 || f == 1) {
            return f;
        }
        
        if (e == 1) {
            return f;
        }
        
        if (dp[e][f] != -1) {
            return dp[e][f];
        }
        
        int res = 1_000_000_000;
        
        for (int cur = 1; cur <= f; cur++) {
            res = Math.min(res, 1 + Math.max(f(e, f - cur, dp), f(e - 1, cur -1, dp)));
        }
        
        return dp[e][f] = res;
    }
    
    public int superEggDrop(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];
        
        for (int[] cur : dp) {
            Arrays.fill(cur, -1);
        }
        
        return f(eggs, floors, dp);
    }
}
*/

// Recursion (TLE)

/*
class Solution {
    public int f(int e, int f) {
        if (f == 0 || f == 1) {
            return f;
        }
        
        if (e == 1) {
            return f;
        }
        
        int res = 1_000_000_000;
        
        for (int cur = 1; cur <= f; cur++) {
            res = Math.min(res, 1 + Math.max(f(e, f - cur), f(e - 1, cur -1)));
        }
        
        return res;
    }
    
    public int superEggDrop(int eggs, int floors) {
        return f(eggs, floors);
    }
}
*/