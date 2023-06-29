class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length, count[] = new int[len + 1];
        for (int i : nums) {
            count[i]++;
            if (res.size() < count[i]) res.add(new ArrayList<>());
            res.get(count[i] - 1).add(i);
        }
        return res;
    }
}