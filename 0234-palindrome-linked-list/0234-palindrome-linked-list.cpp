class Solution {
public:
    ListNode* reverse(ListNode* cur) {
        ListNode* prev = nullptr;
        
        while (cur != nullptr) {
            ListNode* front = cur->next;
            
            cur->next = prev;
            prev = cur;
            cur = front;
        }
        
        return prev;
    }
    
    bool isPalindrome(ListNode* head) {
        ListNode *slow = head, *fast = head;
        
        while (fast->next != nullptr && fast->next->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        fast = slow->next;
        
        fast = reverse(fast);
        
        slow = head;
        
        while (slow != nullptr && fast != nullptr) {
            if (slow->val != fast->val) {
                return false;
            }
            slow = slow->next;
            fast = fast->next;
        }
        
        return true;
    }
};