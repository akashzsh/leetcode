class Solution {
public:
    Node* copyRandomList(Node* head) {
        if (head == nullptr) {
            return head;
        }
        
        Node* cur = head;
        
        while (cur != nullptr) {
            Node* next_node = cur->next;
            cur->next = new Node(cur->val);
            cur->next->next = next_node;
            cur = next_node;
        }
        
        cur = head;
        
        while (cur != nullptr) {
            if (cur->random != nullptr) {
                cur->next->random = cur->random->next;
            }
            cur = cur->next->next;
        }
        
        cur = head;
        Node* new_head = cur->next;
        Node* p = cur->next;
        
        while (p->next != nullptr) {
            cur->next = cur->next->next;
            cur = cur->next;
            p->next = p->next->next;
            p = p->next;
        }
        
        cur->next = cur->next->next;
        
        return new_head;
    }
};