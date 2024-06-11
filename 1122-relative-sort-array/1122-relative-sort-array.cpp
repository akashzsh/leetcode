class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        vector<int> fq(1001);
        
        for (int& j : arr1) {
            fq[j]++;
        }
        
        int i = 0;
        for (int& j : arr2) {
            while (fq[j] > 0) {
                arr1[i++] = j;
                fq[j]--;
            }
        }
        
        for (int j = 0; j < 1001; j++) {
            while (fq[j] > 0) {
                arr1[i++] = j;
                fq[j]--;
            }
        }
        
        return arr1;
    }
};