class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<Pair<Integer, Integer>> seen = new HashSet<>();
        int x = 0, y = 0;
        seen.add(new Pair(x, y));
        for (char ch : path.toCharArray()) {
            if (ch == 'N') {
                y++;
            } else if (ch == 'S') {
                y--;
            } else if (ch == 'E') {
                x++;
            } else {
                x--;
            }
            if (seen.contains(new Pair(x, y))) {
                return true;
            }
            seen.add(new Pair(x, y));
        }
        return false;
    }
}