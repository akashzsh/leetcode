class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String result1 = "", result2 = "";
        for (String current : word1) result1 += current;
        for (String current : word2) result2 += current;
        return result1.equals(result2);
    }
}