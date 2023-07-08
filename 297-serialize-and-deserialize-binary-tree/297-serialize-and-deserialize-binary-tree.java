public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                res.append("n ");
                continue;
            }
            res.append(curr.val + " ");
            q.offer(curr.left);
            q.offer(curr.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                q.offer(parent.left);
            }
            if (!values[++i].equals("n")) {
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                q.offer(parent.right);
            }
        }
        return root;
    }
}