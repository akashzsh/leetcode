import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        int length = s.length(), value = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        for (int i = length - 1; i >= 0; --i) {
            if (i < length - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) value -= map.get(s.charAt(i));
            else value += map.get(s.charAt(i));
        }
        
        return value;
    }
}