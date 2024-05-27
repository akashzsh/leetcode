class Solution {
public:    
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* res = new ListNode(0);
        ListNode* p = res;
        
        int carry = 0;
        
        while (l1 != nullptr || l2 != nullptr || carry != 0) {
            int sum = carry;
            
            if (l1 != nullptr) {
                sum = sum + l1->val;
                l1 = l1->next;
            }
            
            if (l2 != nullptr) {
                sum = sum + l2->val;
                l2 = l2->next;
            }
            
            p->next = new ListNode(sum % 10);
            carry = sum / 10;
            
            p = p->next;
        }
        
        return res->next;
    }
};