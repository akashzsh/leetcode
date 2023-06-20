class Solution {
    public boolean squareIsWhite(String coordinates) {
        boolean res = false;
        boolean check1 = (coordinates.charAt(0) - '0') % 2 == 0;
        boolean check2 = (coordinates.charAt(1) - '0') % 2 == 0;
        if ((check1 && check2) || (!check1 && !check2)) return false;
        return true;
    }
}