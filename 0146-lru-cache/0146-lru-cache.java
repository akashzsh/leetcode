class LRUCache {
    Node head = new Node(0, 0), tail = new Node(0, 0);
    HashMap<Integer, Node> mpp = new HashMap<>();
    int capacity;
    
    private void add(Node cur) {
        mpp.put(cur.key, cur);
        Node headNext = head.next;
        head.next = cur;
        cur.prev = head;
        headNext.prev = cur;
        cur.next = headNext;
    }
    
    private void remove(Node cur) {
        mpp.remove(cur.key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }
    
    class Node {
        Node prev, next;
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (mpp.containsKey(key)) {
            Node cur = mpp.get(key);
            remove(cur);
            add(cur);
            return cur.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (mpp.containsKey(key)) {
            remove(mpp.get(key));
        }
        if (mpp.size() == capacity) {
            remove(tail.prev);
        }
        add(new Node(key, value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */