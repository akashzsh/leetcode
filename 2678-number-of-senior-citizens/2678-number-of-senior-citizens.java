class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String curr : details) {
            int age = (curr.charAt(11) - '0') * 10 + (curr.charAt(12) - '0');
            if (age > 60) count++;
        }
        return count;
    }
}