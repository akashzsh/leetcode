import java.util.HashMap;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        HashMap<Character, Integer> maping = new HashMap<>();
        for (char x : jewels.toCharArray()) maping.put(x, 1);
        for (char x : stones.toCharArray()) if (maping.containsKey(x)) count++;
        return count;
    }
}