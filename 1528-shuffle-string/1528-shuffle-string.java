import java.util.HashMap;

class Solution {
    public String restoreString(String s, int[] indices) {
        String result = "";
        int length = indices.length;
        HashMap<Integer, Character> words = new HashMap<>();
        for (int i = 0; i < length; i++) words.put(indices[i], s.charAt(i));
        for (int i = 0; i < length; i++) result += words.get(i);
        return result;
    }
}