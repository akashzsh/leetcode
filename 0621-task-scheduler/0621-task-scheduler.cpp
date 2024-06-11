class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        vector<int> fq(26, 0);
        
        for (auto& ch : tasks) {
            fq[ch - 'A']++;
        }
        
        priority_queue<int> pq;
        
        for (auto& j : fq) {
            if (j > 0) {
                pq.push(j);
            }
        }
        
        int time = 0;
        
        while (!pq.empty()) {
            vector<int> vt;
            for (int k = 1; k <= n + 1; k++) {
                if (!pq.empty()) {
                    auto cur = pq.top(); pq.pop();
                    cur--;
                    vt.push_back(cur);
                }
            }
            
            for (auto& v : vt) {
                if (v > 0) {
                    pq.push(v);
                }
            }
            
            if (pq.empty()) {
                time += vt.size();
            } else {
                time += n + 1;
            }
        }
        
        return time;
    }
};