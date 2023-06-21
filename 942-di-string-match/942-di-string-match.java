class Solution {
    public int[] diStringMatch(String s) {
        int low = 0, high = s.length(), curr = 0;
        int[] result = new int[s.length() + 1];
        for (char letter : s.toCharArray()) {
            if (letter == 'I') result[curr] = low++;
            else result[curr] = high--;
            curr++;
        }
        if (s.charAt(s.length() - 1) == 'D') result[curr] = high;
        else result[curr] = low;
        return result;
    }
}