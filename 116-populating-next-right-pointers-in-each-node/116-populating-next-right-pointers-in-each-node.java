class Solution {
    public Node connect(Node root) {
        Node steady = root;
        while (root != null && root.left != null) {
            Node curr = root;
            while (curr != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next == null ? null : curr.next.left;
                curr = curr.next;
            }
            root = root.left;
        }
        return steady;
    }
}