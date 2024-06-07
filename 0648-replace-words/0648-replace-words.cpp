class TrieNode {
public:
    vector<TrieNode*> links;
    bool endWord;
    
    TrieNode() : endWord(false), links(26, nullptr) {};
};

class Solution {
public:
    void add(TrieNode* node, string& word) {
        TrieNode* cur = node;
        
        for (auto& ch : word) {
            if (cur->links[ch - 'a'] == nullptr) {
                cur->links[ch - 'a'] = new TrieNode();
            }
            cur = cur->links[ch - 'a'];
        }
        
        cur->endWord = true;
    }
    
    string suitable_word(TrieNode* node, string& word) {
        TrieNode* cur = node;
        string s = "";
        bool flag = true;
        
        for (auto& ch : word) {
            if (cur->links[ch - 'a'] == nullptr) {
                flag = false;
                break;
            }
            cur = cur->links[ch - 'a'];
            s += ch;
            if (cur->endWord) {
                break;
            }
        }
        
        if (!flag) {
            return word;
        }
        
        return s == "" ? word : s;
    }
    
    string replaceWords(vector<string>& dictionary, string sentence) {
        TrieNode* node = new TrieNode();
        
        for (auto& word : dictionary) {
            add(node, word);
        }
        
        int l = 0, r = 0;
        
        string res = "";
        
        for (int n = sentence.size(); r < n; r++) {
            if (sentence[r] != ' ') {
                continue;
            }
            
            string cur = sentence.substr(l, r - l);
            string part = suitable_word(node, cur);
            
            res = res + part + " ";
            l = r + 1;
        }
        
        // cout << suitable_word(node, ss);
        
        string cur = sentence.substr(l, r - l);
        string part = suitable_word(node, cur);
        res = res + part + " ";
        // cout << cur << "\n";
        res.pop_back();
        return res;
    }
};