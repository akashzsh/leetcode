class Solution {
    public boolean solve(int n) {
        int cpy = n;
        while (cpy != 0) {
            int rem = cpy % 10;
            if (rem == 0 || n % rem != 0) return false;
            cpy /= 10;
        }
        return true;
    }
    
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (solve(i)) res.add(i);
        }
        return res;
    }
}