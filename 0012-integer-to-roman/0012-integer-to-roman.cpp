class Solution {
public:
    string intToRoman(int num) {
        vector<string> sym {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        vector<int> val {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        
        string res = "";
        
        for (int i = 12; i >= 0; i--) {
            if (num < 0) {
                break;
            }
            if (val[i] > num) {
                continue;
            }
            int times = num / val[i];
            while (times > 0) {
                res = res + sym[i];
                times--;
            }
            num = num % val[i];
        }
        
        return res;
    }
};