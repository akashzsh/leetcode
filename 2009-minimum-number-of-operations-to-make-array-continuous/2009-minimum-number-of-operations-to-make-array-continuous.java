class Solution {
    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public int minOperations(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        
        for (int i : arr) set.add(i);
        int[] nums = new int[set.size()];
        
        int idx = 0;
        for (int i : set) nums[idx++] = i;
        int len = nums.length;
        
        Arrays.sort(nums);
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int min = nums[i];
            int op = i;
            op += (n - binarySearch(nums, min + n - 1));
            result = Math.min(result, op);
        }
        return result;
    }
}