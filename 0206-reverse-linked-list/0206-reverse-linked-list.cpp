class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode *prev = nullptr;
        
        while (head != nullptr) {
            ListNode *front = head->next;
            
            head->next = prev;
            prev = head;
            head = front;
        }
        
        return prev;
    }
};