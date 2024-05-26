class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if (head == nullptr) {
            return nullptr;
        }
        
        ListNode *odd_head = head, *even_head = head->next;
        ListNode *p1 = head, *p2 = head->next, *trail = p1;
        
        while (p1->next != nullptr && p2->next != nullptr) {
            trail = p1;
            p1->next = p2->next;
            p1 = p1->next;
            p2->next = p1->next;
            p2 = p2->next;
        }
        
        if (p1 == nullptr) {
            trail->next = even_head;
        } else {
            p1->next = even_head;
        }
        
        return odd_head;
    }
};