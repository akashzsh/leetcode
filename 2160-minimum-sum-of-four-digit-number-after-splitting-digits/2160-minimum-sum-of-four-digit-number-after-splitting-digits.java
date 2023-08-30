class Solution {
    public int minimumSum(int num) {
        char[] s = Integer.toString(num).toCharArray();
        Arrays.sort(s);
        return (s[0] - '0' + s[1] - '0') * 10 + s[2] - '0' + s[3] - '0';
    }
}