class Solution {
    public String destCity(List<List<String>> paths) {
        int n = paths.size();
        HashSet<String> set = new HashSet<>();
        for (List<String> cur : paths) {
            set.add(cur.get(0));
        }
        for (List<String> cur : paths) {
            if (!set.contains(cur.get(1))) {
                return cur.get(1);
            }
        }
        return "";
    }
}