class Solution {
    public boolean isThree(int n) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(4, 9, 25, 49, 121, 169, 289, 361, 529, 841, 961, 1369, 1681, 1849, 2209, 2809, 3481, 3721, 4489, 5041, 5329, 6241, 6889, 7921, 9409, 10201));
        return set.contains(n);
    }
}