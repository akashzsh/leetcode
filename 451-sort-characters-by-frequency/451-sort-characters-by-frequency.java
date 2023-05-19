class Solution {
    public String frequencySort(String s) {
        String result = "";
        Character[] input = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) input[i] = s.charAt(i);
        List<Character> list = Arrays.asList(input);
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> mapIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!mapIndex.containsKey(s.charAt(i))) mapIndex.put(s.charAt(i), i);
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Collections.sort(list, new Comparator<Character> () {
            public int compare(Character c1, Character c2) {
                int freq1 = map.get(c1);
                int freq2 = map.get(c2);
                if (freq1 == freq2) return mapIndex.get(c2) - mapIndex.get(c1);
                return freq2 - freq1;
            }
        });
        for (Character letter : list) result += letter;
        return result;
    }
}