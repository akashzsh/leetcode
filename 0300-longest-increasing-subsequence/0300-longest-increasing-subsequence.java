// Binary Search (Most Optimal for calculating length of LIS)

class Solution {
    public int lowerBound(ArrayList<Integer> nums, int target) {
        int low = 0, high = nums.size() - 1;
        
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            
            if (nums.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> vec = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int insertIdx = lowerBound(vec, nums[i]);
            
            if (insertIdx >= vec.size()) {
                vec.add(nums[i]);
            } else {
                vec.set(insertIdx, nums[i]);
            }
        }
        
        return vec.size();
    }
}

// Print the LCS using below Tabulation

/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxi = 1, maxIdx = 0;
        int[] dp = new int[nums.length];
        int[] parent = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            // initially fill dp with 1 cause everyone is itself a LIS of len 1
            dp[i] = 1;
            parent[i] = i;
            for (int pv = 0; pv < i; pv++) {
                if (nums[pv] < nums[i]) {
                    if (1 + dp[pv] > dp[i]) {
                        dp[i] = 1 + dp[pv];
                        parent[i] = pv;
                    }
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
                maxIdx = i;
            }
        }
        
        int[] lis = new int[maxi];
        int k = maxi - 1;
        
        int j = maxIdx;
        while (j != parent[j]) {
            lis[k--] = nums[j];
            j = parent[j];
        }
        
        lis[k--] = nums[j];
        System.out.println(Arrays.toString(lis));
        
        return maxi;
    }
}
*/

// Another Approach of Tabulation

/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxi = 1;
        int[] dp = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            // initially fill dp with 1 cause everyone is itself a LIS of len 1
            dp[i] = 1;
            for (int pv = 0; pv < i; pv++) {
                if (nums[pv] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[pv]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        
        return maxi;
    }
}
*/

// Space Optimization

/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int prev[] = new int[N + 1], cur[] = new int[N + 1];
        
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int pv = i - 1; pv >= -1; pv--) {
                int len = 0 + prev[pv + 1];
        
                if (pv == -1 || nums[i] > nums[pv]) {
                    len = Math.max(len, 1 + prev[i + 1]);
                }

                cur[pv + 1] = len;
            }
            System.arraycopy(cur, 0, prev, 0, N + 1);
        }
        
        return prev[0];
    }
}
*/

// Tabulation

/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int pv = i - 1; pv >= -1; pv--) {
                int len = 0 + dp[i + 1][pv + 1];
        
                if (pv == -1 || nums[i] > nums[pv]) {
                    len = Math.max(len, 1 + dp[i + 1][i + 1]);
                }

                dp[i][pv + 1] = len;
            }
        }
        
        return dp[0][0];
    }
}
*/

// Memoization

/*
class Solution {
    public int f(int i, int pv, int[] nums, int N, int[][] dp) {
        if (i == N) {
            return 0;
        }
        
        if (dp[i][pv + 1] != -1) {
            return dp[i][pv + 1];
        }
        
        int len = 0 + f(i + 1, pv, nums, N, dp);
        
        if (pv == -1 || nums[i] > nums[pv]) {
            len = Math.max(len, 1 + f(i + 1, i, nums, N, dp));
        }
        
        return dp[i][pv + 1] = len;
    }
    
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        
        int[][] dp = new int[N][N + 1];
        
        for (int[] cur : dp) {
            Arrays.fill(cur, -1);
        }
        
        return f(0, -1, nums, N, dp);
    }
}
*/

// Recursion

/*
class Solution {
    public int f(int i, int pv, int[] nums, int N) {
        if (i == N) {
            return 0;
        }
        
        int len = 0 + f(i + 1, pv, nums, N);
        
        if (pv == -1 || nums[i] > nums[pv]) {
            len = Math.max(len, 1 + f(i + 1, i, nums, N));
        }
        
        return len;
    }
    
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        
        return f(0, -1, nums, N);
    }
}
*/