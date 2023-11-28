class Solution {
    public int numberOfWays(String corridor) {
        int n = corridor.length(), m = 1_000_000_007;
        ArrayList<Integer> sPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                sPos.add(i);
            }
        }
        n = sPos.size();
        if (n == 0 || n % 2 != 0) {
            return 0;
        }
        int start = sPos.get(1);
        long result = 1;
        for (int i = 2; i < n; i += 2) {
            int end = sPos.get(i);
            result = (result * (end - start)) % m;
            start = sPos.get(i + 1);
        }
        return (int) result;
    }
}