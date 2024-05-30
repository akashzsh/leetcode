class Solution {
public:
    typedef long long ll;
    
    void f(int i, string ds, vector<string>& res, ll sum, ll prev, string& s, int& target) {
        if (i == s.size()) {
            if (sum == target) {
                res.push_back(ds);
            }
            return;
        }
        ll number = 0;
        string acc = "";
        for (int j = i; j < s.size(); j++) {
            if (j > i && s[i] == '0') {
                break;
            }
            acc = acc + s[j];
            number = number * 10 + (s[j] - '0');
            if (i == 0) {
                f(j + 1, ds + acc, res, number, number, s, target);
            } else {
                f(j + 1, ds + "+" + acc, res, sum + number, number, s, target);
                f(j + 1, ds + "-" + acc, res, sum - number, -number, s, target);
                f(j + 1, ds + "*" + acc, res, (sum - prev) + (number * prev), number * prev, s, target);
            }
        }
    }
    
    vector<string> addOperators(string num, int target) {
        vector<string> res;
        
        f(0, "", res, 0, 0, num, target);
        
        return res;
    }
};