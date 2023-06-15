class Solution {
    public String capitalizeTitle(String title) {
        char[] stream = title.toCharArray();
        int firstLetter;
        for (int i = 0; i < stream.length; i++) {
            firstLetter = i;
            while (i < stream.length && stream[i] != ' ') {
                stream[i] = Character.toLowerCase(stream[i]);
                i++;
            }
            if (i - firstLetter > 2)
                stream[firstLetter] = Character.toUpperCase(stream[firstLetter]);
        }
        return String.valueOf(stream);
    }
}