class Solution {
public:
    ListNode* merge(ListNode* partA, ListNode* partB) {
        ListNode* res = new ListNode(0);
        ListNode* head = res;
        
        while (partA != nullptr && partB != nullptr) {
            if (partA->val <= partB->val) {
                res->next = partA;
                partA = partA->next;
            } else {
                res->next = partB;
                partB = partB->next;
            }
            res = res->next;
        }
        
        while (partA != nullptr) {
            res->next = partA;
            partA = partA->next;
            res = res->next;
        }
        
        while (partB != nullptr) {
            res->next = partB;
            partB = partB->next;
            res = res->next;
        }
        
        return head->next;
    }
    
    ListNode* sortList(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        
        ListNode *slow = head, *fast = head, *trail = head;
        
        while (fast != nullptr && fast->next != nullptr) {
            trail = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        
        trail->next = nullptr;
        
        ListNode *partA = sortList(head), *partB = sortList(slow);
        
        return merge(partA, partB);
    }
};