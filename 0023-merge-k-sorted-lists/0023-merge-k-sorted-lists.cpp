class Solution {
public:
    typedef pair<int, ListNode*> dt;
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<dt, vector<dt>, greater<dt>> pq;
        
        for (auto& j : lists) {
            if (j) pq.push({j->val, j});
        }
        
        ListNode* dummy = new ListNode(-1);
        ListNode* pt = dummy;
        
        while (!pq.empty()) {
            auto cur = pq.top(); pq.pop();
            pt->next = cur.second;
            pt = pt->next;
            
            if (cur.second->next) {
                pq.push({cur.second->next->val, cur.second->next});
            }
        }
        
        pt->next = nullptr;
        return dummy->next;
    }
};