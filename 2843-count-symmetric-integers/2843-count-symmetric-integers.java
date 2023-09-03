class Solution {
    private boolean isSymmetric(int n) {
        StringBuilder num = new StringBuilder();
        num.append(n);
        if (num.length() % 2 != 0) return false;
        int left = 0, right = 0, len = num.length() / 2;
        for (int i = 0; i < len; i++) left += (num.charAt(i) - '0');
        for (int i = len; i < num.length(); i++) right += (num.charAt(i) - '0');
        return left == right;
    }
    
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) cnt++;
        }
        return cnt;
    }
}