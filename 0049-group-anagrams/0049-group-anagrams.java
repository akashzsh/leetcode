class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {        
        HashMap<String, List<String>> mpp = new HashMap<>();
        for (String s : strs) {
            char[] ch = new char[26];
            for (char lt : s.toCharArray()) ch[lt - 'a']++;
            String tmp = String.valueOf(ch);
            if (!mpp.containsKey(tmp)) mpp.put(tmp, new ArrayList<>());
            mpp.get(tmp).add(s);
        }
        return new ArrayList<>(mpp.values());
    }
}