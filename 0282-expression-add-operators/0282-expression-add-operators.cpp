class Solution {
public:
    typedef long long ll;
    
    void f(int i, string ds, ll sum, ll prev, vector<string>& res, string& s, int& target, int& N) {
        if (i == N) {
            if (sum == target) {
                res.push_back(ds);
            }
            return;
        }
        
        ll number = 0;
        string acc = "";
        for (int j = i; j < N; j++) {
            if (j > i && s[i] == '0') {
                break;
            }
            number = number * 10 + (s[j] - '0');
            acc = acc + s[j];
            if (i == 0) {
                f(j + 1, ds + acc, number, number, res, s, target, N);
            } else {
                f(j + 1, ds + "+" + acc, sum + number, number, res, s, target, N);
                f(j + 1, ds + "-" + acc, sum - number, -number, res, s, target, N);
                f(j + 1, ds + "*" + acc, (sum - prev) + (number * prev), prev * number, res, s, target, N);
            }
        }
    }
    
    vector<string> addOperators(string num, int target) {
        int N = num.size();
        
        vector<string> res;
        
        f(0, "", 0, 0, res, num, target, N);
        
        return res;
    }
};