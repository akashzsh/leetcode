class Solution {
public:
    typedef pair<double, pair<int, int>> pp;
    
    template<typename T>
    using min_heap = priority_queue<T, vector<T>>;
    
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        min_heap<pp> pq;
        
        int N = arr.size();
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double cur = (double)(arr[i]) / (double)(arr[j]);
                pq.push({cur, {i, j}});
                
                if (pq.size() > k) {
                    pq.pop();
                }
            }
        }
        
        vector<int> res {arr[pq.top().second.first], arr[pq.top().second.second]};
        return res;
    }
};