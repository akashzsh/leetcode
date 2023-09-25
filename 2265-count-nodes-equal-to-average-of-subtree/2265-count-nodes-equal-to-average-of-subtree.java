class Solution {
    private int count = 0;
    
    private Pair<Integer, Integer> countNodes(TreeNode node) {
        if (node == null) return new Pair(0, 0);
        Pair<Integer, Integer> left = countNodes(node.left);
        Pair<Integer, Integer> right = countNodes(node.right);
        int sum = left.getKey() + right.getKey() + node.val;
        int cnt = left.getValue() + right.getValue() + 1;
        if (node.val == (sum / cnt)) count++;
        return new Pair(sum, cnt);
    }
    
    public int averageOfSubtree(TreeNode root) {
        countNodes(root);
        return count;
    }
}