class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode *p1 = headA, *p2 = headB;
        
        while (p1 != p2) {
            if (p1->next == nullptr && p2->next == nullptr) {
                return nullptr;
            }
            
            p1 = p1->next;
            
            if (p1 == nullptr) {
                p1 = headB;
            }
            
            p2 = p2->next;
            
            if (p2 == nullptr) {
                p2 = headA;
            }
        }
        
        return p1;
    }
};