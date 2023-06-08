class Solution {
    public List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();
        int low = Character.getNumericValue(s.charAt(1));
        int high = Character.getNumericValue(s.charAt(4));
        int maximum = Math.max(low, high);
        for (char letter = s.charAt(0); letter <= s.charAt(3); letter++) {
            int curr = low;
            while (curr != high + 1) {
                String res = letter + Integer.toString(curr);
                curr++;
                result.add(res);
            }
        }
        return result;
    }
}