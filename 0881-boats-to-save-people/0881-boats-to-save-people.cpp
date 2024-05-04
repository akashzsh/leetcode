class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(people.begin(), people.end());
        
        int i = 0, j = people.size() - 1, boats = 0;
        
        while (i < j) {
            
            if (people[i] + people[j] <= limit) {
                boats++;
                i++;
                j--;
            } else {
                boats++;
                j--;
            }
            
        }
        
        if (i == j) {
            boats++;
        }
        
        return boats;
    }
};