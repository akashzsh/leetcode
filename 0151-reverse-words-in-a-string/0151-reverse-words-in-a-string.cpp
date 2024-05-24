class Solution {
public:
    string reverseWords(string s) {
        string res;
        
        for (int i = s.size() - 1; i >= 0;) {
            while (i >= 0 && s[i] == ' ') {
                i--;
            }
            
            if (i < 0) {
                break;
            }
            
            int j = i;
            while (i >= 0 && s[i] != ' ') {
                i--;
            }
            
            for (int k = i + 1; k <= j; k++) {
                res = res + s[k];
            }
            
            res = res + ' ';
        }
        
        res.pop_back();
        return res;
    }
};

static const auto __optimize__ = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    return 0;
}();