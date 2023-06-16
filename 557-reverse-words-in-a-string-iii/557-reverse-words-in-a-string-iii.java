class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int pos = 0;
        for (String word : words) {
            char[] help = word.toCharArray();
            int low = 0, high = help.length - 1;
            while (low < high) {
                char temp = help[low];
                help[low] = help[high];
                help[high] = temp;
                low++;
                high--;
            }
            words[pos++] = String.valueOf(help);
        }
        String result = "";
        for (String curr : words) result += curr + " ";
        return result.substring(0, s.length());
    }
}