import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> candiesList = new ArrayList<>();
        int maximum = candies[0];
        for (int i : candies) if (i > maximum) maximum = i;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maximum) candiesList.add(i, true);
            else candiesList.add(i, false);
        }
        return candiesList;
    }
}