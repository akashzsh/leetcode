class Solution {
public:
    void nge(vector<int>& nums, int& N, vector<int>& res) {
        stack<int> stk;
        
        for (int i = N - 1; i >= 0; i--) {
            while (!stk.empty() && nums[stk.top()] <= nums[i]) {
                stk.pop();
            }
            
            if (stk.empty()) {
                res[i] = -1;
            } else {
                res[i] = stk.top();
            }
            
            stk.push(i);
        }
    }
    
    ListNode* removeNodes(ListNode* head) {
        vector<int> nums;
        
        while (head != NULL) {
            nums.push_back(head->val);
            head = head->next;
        }
        
        int N = nums.size();
        
        vector<int> res(N, 0);
        
        nge(nums, N, res);
        
        ListNode* ll = new ListNode(0);
        head = ll;
        
        for (int i = 0; i < N; i++) {
            if (res[i] == -1) {
                ll->next = new ListNode(nums[i]);
                ll = ll->next;
            }
        }
        
        return head->next;
    }
};