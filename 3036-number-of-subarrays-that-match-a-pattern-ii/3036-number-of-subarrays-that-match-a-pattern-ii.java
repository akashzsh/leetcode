class Solution {
    public void calculateLPS(int[] pattern, int[] LPS) {
        int idx = 0, i = 1;
        while (i < pattern.length) {
            if (pattern[idx] == pattern[i]) {
                LPS[i] = idx + 1;
                idx++;
                i++;
            } else {
                if (idx != 0) {
                    idx = LPS[idx - 1];
                } else {
                    i++;
                }
            }
        }
    }
    
    public int KMP(int[] text, int[] pattern) {
        int cnt = 0;
        int[] LPS = new int[pattern.length];
        calculateLPS(pattern, LPS);
        
        int i = 0, j = 0;
        while (i < text.length) {
            if (j < pattern.length && text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j == pattern.length) {
                    cnt++;
                }
                if (j != 0) {
                    j = LPS[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        if (j == pattern.length) {
            cnt++;
        }
        
        return cnt;
    }
    
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int[] text = new int[nums.length - 1];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                text[i - 1] = 1;
            } else if (nums[i] == nums[i - 1]) {
                text[i - 1] = 0;
            } else if (nums[i] < nums[i - 1]) {
                text[i - 1] = -1;
            }
        }
        
        return KMP(text, pattern);
    }
}