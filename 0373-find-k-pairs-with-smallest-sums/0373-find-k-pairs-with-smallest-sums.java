class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        
        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
        set.add(new Pair(0, 0));
        
        while (k > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[1];
            int j = cur[2];
            res.add(List.of(nums1[i], nums2[j]));
            
            if (j + 1 < len2 && !set.contains(new Pair(i, j + 1))) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                set.add(new Pair(i, j + 1));
            }
            
            if (i + 1 < len1 && !set.contains(new Pair(i + 1, j))) {
                pq.add(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                set.add(new Pair(i + 1, j));
            }
            
            k--;
        }
        
        return res;
    }
}