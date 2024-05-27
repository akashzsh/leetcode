class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        
        int cnt = 1;
        
        ListNode* cur = head;
        
        while (cur->next != nullptr) {
            cnt++;
            cur = cur->next;
        }
        
        k = cnt - (k % cnt);
        
        cur->next = head;
        
        cur = head;
        
        while (--k) {
            cur = cur->next;
        }
        
        head = cur->next;
        
        cur->next = nullptr;
        
        return head;
    }
};