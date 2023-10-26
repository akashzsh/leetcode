class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long mod = 1000000007;
        int n = arr.length;
        Arrays.sort(arr);
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(arr[0], 1L);
        
        for (int i = 1; i < n; i++) {
            int root = arr[i];
            map.put(root, 1L);
            for (int j = 0; j < i; j++) {
                int leftChild = arr[j];
                if (root % leftChild == 0 && map.containsKey(root / leftChild)) {
                    map.put(root, map.get(root) +
                            (map.get(leftChild) * map.get(root / leftChild)));
                }
            }
        }
        
        long ans = 0;
        for (long i : map.values()) {
            ans = (ans + i) % 1000000007;
        }
        return (int)(ans);
    }
}