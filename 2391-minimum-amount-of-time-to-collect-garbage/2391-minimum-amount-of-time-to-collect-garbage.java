class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] prefixSum = new int[travel.length + 1];
        prefixSum[1] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            prefixSum[i + 1] = travel[i] + prefixSum[i];
        }
        HashMap<Character, Integer> lastPos = new HashMap<>();
        HashMap<Character, Integer> quantity = new HashMap<>();
        for (int i = 0; i < garbage.length; i++) {
            for (char ch : garbage[i].toCharArray()) {
                lastPos.put(ch, i);
                quantity.put(ch, quantity.getOrDefault(ch, 0) + 1);
            }
        }
        int mins = 0;
        for (char ch : "MPG".toCharArray()) {
            if (lastPos.containsKey(ch)) {
                mins += prefixSum[lastPos.get(ch)] + quantity.get(ch);
            }
        }
        return mins;
    }
}