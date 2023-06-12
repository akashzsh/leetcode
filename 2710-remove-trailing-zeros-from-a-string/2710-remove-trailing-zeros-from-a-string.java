class Solution {
    public String removeTrailingZeros(String num) {
        StringBuilder result = new StringBuilder();
        int last = num.length() - 1;
        for (int i = last; i >= 0; --i) {
            if (num.charAt(i) != '0') break;
            last--;
        }
        for (int i = 0; i <= last; i++) result.append(num.charAt(i));
        return result.toString();
    }
}