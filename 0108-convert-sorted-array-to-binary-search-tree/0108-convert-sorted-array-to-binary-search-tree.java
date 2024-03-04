class Solution {
    public TreeNode f(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        
        int mid = low + ((high - low) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = f(nums, low, mid - 1);
        root.right = f(nums, mid + 1, high);
        
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return f(nums, 0, nums.length - 1);
    }
}