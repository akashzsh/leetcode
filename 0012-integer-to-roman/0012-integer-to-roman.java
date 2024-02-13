class Solution {
    public String intToRoman(int num) {
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            if (num == 0) {
                break;
            }
            if (vals[i] > num) {
                continue;
            }
            int times = num / vals[i];
            while (times > 0) {
                sb.append(strs[i]);
                times--;
            }
            num = num % vals[i];
        }
        
        return sb.toString();
    }
}