class Solution {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        LinkedList<String> res = new LinkedList<>();
        if (len == 0) return res;
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < len; i++) {
            int curr = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String tmp = res.remove();
                for (char l : mapping[curr].toCharArray()) {
                    res.add(tmp + l);
                }
            }
        }
        return res;
    }
}