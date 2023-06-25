class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int curr = columnNumber % 26;
            columnNumber /= 26;
            res.append((char)(curr + 'A'));
        }
        return res.reverse().toString();
    }
}