class Solution {
    public int countPoints(String rings) {
        int[] rods = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            int color = rings.charAt(i) == 'R' ? 1 : rings.charAt(i) == 'B' ? 2 : 4;
            rods[rings.charAt(i + 1) - '0'] |= color;
        }
        int res = 0;
        for (int i : rods) if (i == 7) res++;
        return res;
    }
}