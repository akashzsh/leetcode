class Solution {
    public void populate(Node cur, Node next) {
        if (cur == null) {
            return;
        }
        
        cur.next = next;
        
        populate(cur.left, cur.right);
        populate(cur.right, cur.next == null ? null : cur.next.left);
    }
    
    public Node connect(Node root) {
        populate(root, null);
        return root;
    }
}