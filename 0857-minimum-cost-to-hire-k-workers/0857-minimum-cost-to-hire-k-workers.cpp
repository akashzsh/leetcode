class Solution {
public:
    double mincostToHireWorkers(vector<int>& quality, vector<int>& wage, int k) {
        vector<pair<double, int>> vc;
        
        int N = quality.size();
        
        for (int i = 0; i < N; i++) {
            vc.push_back({(wage[i] * 1.0) / quality[i], quality[i]});
        }
        
        sort(vc.begin(), vc.end());
        
        priority_queue<int> pq;
        
        double res = DBL_MAX, q = 0;
        
        for (const auto& cur : vc) {
            q += cur.second;
            pq.push(cur.second);
            
            if (pq.size() > k) {
                q -= pq.top();
                pq.pop();
            }
            
            if (pq.size() == k) {
                res = min(res, q * cur.first);
            }
        }
        
        return res;
    }
};