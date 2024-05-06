class Solution {
public:
    ListNode* reverse(ListNode* cur) {
        ListNode* prev = nullptr;
        
        while (cur != NULL) {
            ListNode* front = cur->next;
            cur->next = prev;
            prev = cur;
            cur = front;
        }
        
        return prev;
    }
    
    ListNode* removeNodes(ListNode* head) {
        head = reverse(head);
        
        ListNode* list = new ListNode(-1);
        ListNode* prev = list;
        ListNode* cur = head;
        
        while (cur != nullptr) {
            if (cur->val >= prev->val) {
                prev->next = new ListNode(cur->val);
                prev = prev->next;
                cur = cur->next;
            } else {
                cur = cur->next;
            }
        }
        
        return reverse(list->next);
    }
};

// 5 2 13 3 8
// 8 3 13 2 5
// -1 -> 8 -> 13
// 13 -> 8