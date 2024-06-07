class Node {
public:
    int key;
    int val;
    Node* prev;
    Node* next;
    
    Node(int key, int val) {
        this->key = key;
        this->val = val;
        this->prev = nullptr;
        this->next = nullptr;
    }
};

class LRUCache {
public:
    unordered_map<int, Node*> xt;
    Node *head, *tail;
    int capacity;
    
    void add(Node* node) {
        xt[node->key] = node;
        Node* head_next = head->next;
        head->next = node;
        node->prev = head;
        node->next = head_next;
        head_next->prev = node;
    }
    
    void remove(Node* node) {
        xt.erase(node->key);
        node->prev->next = node->next;
        node->next->prev = node->prev;
    }
    
    LRUCache(int capacity) {
        this->capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        if (xt.find(key) == xt.end()) {
            return -1;
        }
        Node* cur = xt[key];
        remove(cur);
        add(cur);
        return cur->val;
    }
    
    void put(int key, int value) {
        if (xt.find(key) != xt.end()) {
            remove(xt[key]);
        } else if (xt.size() >= capacity) {
            remove(tail->prev);
        }
        Node* cur = new Node(key, value);
        add(cur);
    }
};