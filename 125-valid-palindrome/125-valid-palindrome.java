class Solution {
    public boolean isPalindrome(String s) {
        char[] redefine = s.toCharArray();
        int low = 0, high = redefine.length - 1;
        while (low < high) {
            if (!Character.isLetterOrDigit(redefine[low])) low++;
            else if (!Character.isLetterOrDigit(redefine[high])) high--;
            else {
                if (Character.toLowerCase(redefine[low]) != Character.toLowerCase(redefine[high])) return false;
                low++; high--;
            } 
        }
        return true;
    }
}