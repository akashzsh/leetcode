class Solution {
public:
    bool isValidSerialization(string preorder) {
        stringstream ss(preorder);
        string cur;
        
        int nodes = 1;
        
        // count how many nodes are permissible-- for non leaf nodes 2 are permissible
        while (getline(ss, cur, ',')) {
            nodes--;
            
            if (nodes < 0) {
                return false;
            }
            
            if (cur != "#") {
                nodes += 2;
            }
        }
        
        return nodes == 0;
    }
};