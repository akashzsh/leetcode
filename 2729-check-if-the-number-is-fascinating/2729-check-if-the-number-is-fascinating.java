class Solution {
    public boolean isFascinating(int n) {
        String txp = new StringBuilder().append(n).append(2 * n).append(3 * n).toString();
        HashSet<Integer> set = new HashSet<>();
        for (char letter : txp.toCharArray())
            set.add(Character.getNumericValue(letter));
        return txp.length() == 9 && set.size() == 9 && !set.contains(0);
    }
}