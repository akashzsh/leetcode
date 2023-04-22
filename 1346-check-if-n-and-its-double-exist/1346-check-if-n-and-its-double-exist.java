class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> elements = new HashSet<>();
        for (int i : arr) {
            if (elements.contains(2 * i) || i % 2 == 0 && elements.contains(i / 2))
                return true;
            elements.add(i);
        }
        return false;
    }
}