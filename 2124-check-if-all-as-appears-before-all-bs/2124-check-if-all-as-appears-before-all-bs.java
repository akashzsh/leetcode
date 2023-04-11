class Solution {
    public boolean checkString(String s) {
        boolean check = true;
        for (char letter : s.toCharArray()) {
            if (letter == 'b') check = false;
            if (letter == 'a' && check == false) return false;
        }
        return true;
    }
}