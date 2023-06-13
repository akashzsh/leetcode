class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String curr : details) {
            String temp = Character.toString(curr.charAt(11)) + Character.toString(curr.charAt(12));
            if (Integer.valueOf(temp) > 60) count++;
        }
        return count;
    }
}