class Solution {
public:
    ListNode* deleteMiddle(ListNode* head) {
        if (head->next == nullptr) {
            delete head;
            return nullptr;
        }
        
        ListNode *slow = head, *fast = head, *trail = head;
        
        while (fast != nullptr && fast->next != nullptr) {
            trail = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        
        trail->next = slow->next;
        slow->next = nullptr;
        delete slow;
        
        return head;
    }
};