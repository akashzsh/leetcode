class Solution {
    public int maximum69Number (int num) {
        StringBuilder result = new StringBuilder();
        result.append(num);
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '6') {
                result.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(result.toString());
    }
}