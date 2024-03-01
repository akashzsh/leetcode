class Solution {
    public String maximumOddBinaryNumber(String s) {
        int N = s.length(), ones = 0;
        
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < ones - 1; i++) {
            sb.append('1');
        }
        
        for (int i = 0; i < N - ones; i++) {
            sb.append('0');
        }
        
        sb.append('1');
        
        return sb.toString();
    }
}