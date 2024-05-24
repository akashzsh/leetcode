class Solution {
public:
    string removeOuterParentheses(string s) {
        string res;
        
        for (int i = 0, n = s.size(), open = 0; i < n; i++) {
            if (s[i] == '(') {
                if (open > 0) {
                    res = res + '(';
                }
                open++;
            } else {
                if (open > 1) {
                    res = res + ')';
                }
                open--;
            }
        }
        
        return res;
    }
};

/*

while adding '(' we are checking if there is already an open bracket in stock, if yes then this is not the outermost one so we can add it to res

same for ')' if there is 1 opening bracket in stock then it will be for the outermost pair, so we need more than 1 open bracket for this close bracket matching
*/