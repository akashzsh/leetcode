class Node {
public:
    int key;
    int val;
    int freq;
    Node* prev;
    Node* next;
    
    Node(int key, int val) {
        this->key = key;
        this->val = val;
        this->freq = 1;
        this->prev = nullptr;
        this->next = nullptr;
    }
};

class DLL {
public:
    Node* head;
    Node* tail;
    int length;
    
    DLL() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head->next = tail;
        tail->prev = head;
        length = 0;
    }
    
    void add(Node* node) {
        length = length + 1;
        Node* head_next = head->next;
        head->next = node;
        node->prev = head;
        head_next->prev = node;
        node->next = head_next;
    }
    
    void remove(Node* node) {
        length = length - 1;
        node->prev->next = node->next;
        node->next->prev = node->prev;
    }
};

class LFUCache {
public:
    unordered_map<int, DLL*> fwm;
    unordered_map<int, Node*> xt;
    int capacity;
    int nodes;
    int min_freq;
    
    LFUCache(int capacity) {
        this->capacity = capacity;
        this->nodes = 0;
        this->min_freq = 0;
    }
    
    int get(int key) {
        if (xt.find(key) == xt.end()) {
            return -1;
        }
        Node* node = xt[key];
        update(node);
        return node->val;
    }
    
    void put(int key, int value) {
        if (xt.find(key) != xt.end()) {
            Node* node = xt[key];
            node->val = value;
            update(node);
        } else {
            nodes++;
            DLL* list;
            if (nodes > capacity) {
                list = fwm[min_freq];
                xt.erase(list->tail->prev->key);
                list->remove(list->tail->prev);
                nodes--;
            }
            min_freq = 1;
            if (fwm.find(min_freq) != fwm.end()) {
                list = fwm[min_freq];
            } else {
                list = new DLL();
            }
            Node* node = new Node(key, value);
            list->add(node);
            fwm[min_freq] = list;
            xt[key] = node;
        }
    }
    
    void update(Node* node) {
        int frequency = node->freq;
        DLL* list = fwm[frequency];
        list->remove(node);
        fwm[frequency] = list;
        if (frequency == min_freq && list->length == 0) {
            min_freq += 1;
        }
        node->freq += 1;
        if (fwm.find(node->freq) != fwm.end()) {
            list = fwm[node->freq];
        } else {
            list = new DLL();
        }
        list->add(node);
        fwm[node->freq] = list;
    }
};