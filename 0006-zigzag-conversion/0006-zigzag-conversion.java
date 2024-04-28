class Solution {
    public String convert(String s, int R) {
        StringBuilder[] vec = new StringBuilder[R];
        
        for (int i = 0; i < R; i++) {
            vec[i] = new StringBuilder();
        }
        
        int N = s.length(), i = 0, j = 0;
        
        while (i < N) {
            while (i < N && j < R) {
                vec[j].append(s.charAt(i));
                i++;
                j++;
            }
            j -= 2;
            int k = 0;
            while (i < N && k < R - 2) {
                vec[j--].append(s.charAt(i));
                i++;
                k++;
            }
            j = 0;
        }
        
        StringBuilder res = new StringBuilder();
        
        for (StringBuilder sb : vec) {
            res.append(sb);
        }
        
        return res.toString();
    }
}