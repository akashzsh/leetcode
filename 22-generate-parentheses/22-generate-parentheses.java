class Solution {
    public void formation(int n, int leftCount, int rightCount, StringBuilder curr, List<String> res) {
        if (curr.length() == 2 * n) {
            res.add(curr.toString());
            return;
        }
        if (leftCount < n) {
            curr.append("(");
            formation(n, leftCount + 1, rightCount, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (leftCount > rightCount) {
            curr.append(")");
            formation(n, leftCount, rightCount + 1, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        formation(n, 0, 0, new StringBuilder(), res);
        return res;
    }
}