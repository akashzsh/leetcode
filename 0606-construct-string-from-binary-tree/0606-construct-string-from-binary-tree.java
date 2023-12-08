class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        
        if (left == "" && right == "") return root.val + "";
        
        return root.val +
                    "(" + left + ")" + (right == "" ? "" : "(" + right + ")");
    }
}