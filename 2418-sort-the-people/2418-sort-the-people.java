class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        String[] result = new String[len];
        for (int i = len - 1, j = 0; i >= 0; i--, j++) {
            result[j] = map.get(heights[i]);
        }
        return result;
    }
}