class Solution {
public:
    void deleteNode(ListNode* node) {
        ListNode* nx = node->next;
        node->val = node->next->val;
        node->next = node->next->next;
        delete(nx);
    }
};