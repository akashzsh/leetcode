class Solution {
public:
    void reverse(string &word, int start, int end) {
        while (start < end) {
            int t = word[start];
            word[start] = word[end];
            word[end] = t;
            start++;
            end--;
        }
    }
    
    string reversePrefix(string word, char ch) {
        int N = word.size();
        
        int i = 0;
        
        while (i < N) {
            if (word[i] == ch) {
                break;
            }
            i++;
        }
        
        if (i != N) {
            reverse(word, 0, i);
        }
        
        return word;
    }
};