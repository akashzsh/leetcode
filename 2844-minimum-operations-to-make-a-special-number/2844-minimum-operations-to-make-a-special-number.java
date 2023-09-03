class Solution {
    public int minimumOperations(String num) {
        boolean zeroFound = false, fiveFound = false;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (zeroFound && num.charAt(i) == '0' ||
                zeroFound && num.charAt(i) == '5' ||
                fiveFound && num.charAt(i) == '7' ||
                fiveFound && num.charAt(i) == '2') return num.length() - 2 - i;
            if (num.charAt(i) == '0') zeroFound = true;
            else if (num.charAt(i) == '5') fiveFound = true;
        }
        if (zeroFound) return num.length() - 1;
        return num.length();
    }
}