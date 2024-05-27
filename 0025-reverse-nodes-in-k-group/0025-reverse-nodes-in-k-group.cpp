class Solution {
public:
    ListNode* reverseLL(ListNode* cur) {
        ListNode* prev = nullptr;
        
        while (cur != nullptr) {
            ListNode* front = cur->next;
            cur->next = prev;
            prev = cur;
            cur = front;
        }
        
        return prev;
    }
    
    ListNode* find_kth_node(ListNode* node, int k) {
        k--;
        while (k) {
            node = node->next;
            if (node == nullptr) {
                return nullptr;
            }
            k--;
        }
        return node;
    }
    
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* cur = head;        
        
        ListNode* prev = nullptr;
        while (cur != nullptr) {
            ListNode* kth = find_kth_node(cur, k);
            
            if (kth == nullptr) {
                if (prev != nullptr) {
                    prev->next = cur;
                }
                break;
            }
            
            ListNode* next_node = kth->next;
            kth->next = nullptr;
            
            reverseLL(cur);
            
            if (head == cur) {
                head = kth;
            } else {
                prev->next = kth;
            }
            
            prev = cur;
            cur = next_node;
        }
        
        return head;
    }
};