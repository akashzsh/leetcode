public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            
            if (cur != null) {
                sb.append(cur.val + ",");
            } else {
                sb.append("$,");
                continue;
            }

            q.add(cur.left);
            q.add(cur.right);
        }
        
        // System.out.println(sb.toString());
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            
            if (!values[i].equals("$")) {
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(parent.left);
            }
            
            if (!values[++i].equals("$")) {
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(parent.right);
            }
        }
        
        return root;
    }
}

// [2, 1, 3, $, $, $, $]