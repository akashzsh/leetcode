class LFUCache {
    final int capacity;
    int minFreq, curSize;
    Map<Integer, Node> mp;
    Map<Integer, DLL> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFreq = 0;
        this.mp = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node curNode = mp.get(key);
        if (curNode == null) return -1;
        updateNode(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (mp.containsKey(key)) {
            Node cur = mp.get(key);
            cur.val = value;
            updateNode(cur);
        } else {
            curSize++;
            if (curSize > capacity) {
                DLL list = frequencyMap.get(minFreq);
                mp.remove(list.tail.prev.key);
                list.remove(list.tail.prev);
                curSize--;
            }
            minFreq = 1;
            Node newNode = new Node(key, value);
            DLL newList = frequencyMap.getOrDefault(1, new DLL());
            newList.add(newNode);
            frequencyMap.put(1, newList);
            mp.put(key, newNode);
        }
    }
    
    public void updateNode(Node curNode) {
        int freq = curNode.frequency;
        DLL tmp = frequencyMap.get(freq);
        tmp.remove(curNode);
        if (freq == minFreq && tmp.listSize == 0) {
            minFreq++;
        }
        curNode.frequency++;
        DLL newList = frequencyMap.getOrDefault(curNode.frequency, new DLL());
        newList.add(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }
    
    class Node {
        int key;
        int val;
        int frequency;
        Node next, prev;
        Node (int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    class DLL {
        int listSize;
        Node head, tail;

        DLL() {
            this.listSize = 0;
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            Node headNext = head.next;
            node.next = headNext;
            node.prev = head;
            head.next = node;
            headNext.prev = node;
            listSize++;
        }

        void remove(Node node) {
            Node nodePrev = node.prev;
            Node nodeNext = node.next;
            nodePrev.next = nodeNext;
            nodeNext.prev = nodePrev;
            listSize--;
        }
    }

}