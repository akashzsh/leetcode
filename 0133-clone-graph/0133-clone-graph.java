class Solution {
    public void f(Node node, HashMap<Node, Node> map) {
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        
        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                f(neighbor, map);
            }
            newNode.neighbors.add(map.get(neighbor));
        }
    }
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }        
        HashMap<Node, Node> map = new HashMap<>();
        f(node, map);
        return map.get(node);
    }
}