class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (head->next == nullptr) {
            return nullptr;
        }
        
        ListNode* dummy = new ListNode(0, head);
        ListNode *fast = dummy, *slow = dummy;
        
        for (int i = 0; i < n; i++) {
            fast = fast->next;
        }
        
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next;
        }
        
        slow->next = slow->next->next;
        
        return dummy->next;
    }
};