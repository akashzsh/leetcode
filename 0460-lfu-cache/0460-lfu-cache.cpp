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
        this->length = 0;
    }
    
    void add(Node* node) {
        Node* head_next = head->next;
        head->next = node;
        node->prev = head;
        node->next = head_next;
        head_next->prev = node;
        length++;
    }
    
    void remove(Node* node) {
        node->prev->next = node->next;
        node->next->prev = node->prev;
        length--;
    }
};

class LFUCache {
public:
    unordered_map<int, DLL*> fwm;
    unordered_map<int, Node*> xt;
    int min_freq, nodes, capacity;
    
    LFUCache(int capacity) {
        this->capacity = capacity;
        this->nodes = 0;
        this->min_freq = 1;
    }
    
    int get(int key) {
        if (xt.find(key) == xt.end()) {
            return -1;
        }
        Node* cur = xt[key];
        update(cur);
        return cur->val;
    }
    
    void put(int key, int value) {
        if (xt.find(key) != xt.end()) {
            Node* cur = xt[key];
            cur->val = value;
            update(cur);
        } else {
            DLL* list = nullptr;
            nodes++;
            if (nodes > capacity) {
                list = fwm[min_freq];
                xt.erase(list->tail->prev->key);
                list->remove(list->tail->prev);
                nodes--;
            }
            min_freq = 1;
            Node* new_node = new Node(key, value);
            if (fwm.find(1) == fwm.end()) {
                list = new DLL();
            } else {
                list = fwm[1];
            }
            
            list->add(new_node);
            fwm[1] = list;
            xt[key] = new_node;
        }
    }
    
    void update(Node* node) {
        int frequency = node->freq;
        DLL* list = fwm[frequency];
        list->remove(node);
        fwm[frequency] = list;
        
        if (frequency == min_freq && list->length == 0) {
            min_freq++;
        }
        
        node->freq++;
        if (fwm.find(node->freq) == fwm.end()) {
            list = new DLL();
        } else {
            list = fwm[node->freq];
        }
        
        list->add(node);
        fwm[node->freq] = list;
    }
};