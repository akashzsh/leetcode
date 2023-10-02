class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length(), alice = 0, bob = 0;
        for (int i = 1; i < n - 1; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') alice++;
                else bob++;
            }
        }
        return alice - bob >= 1;
    }
}