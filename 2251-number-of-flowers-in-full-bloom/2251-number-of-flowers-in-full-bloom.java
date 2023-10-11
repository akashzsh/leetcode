class Solution {
    private int binarySearch(ArrayList<Integer> nums, int target) {
        int low = 0, high = nums.size() - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums.get(mid) <= target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = people.length;
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();
        
        for (int[] cur : flowers) {
            start.add(cur[0]);
            end.add(cur[1] + 1);
        }
        
        Collections.sort(start);
        Collections.sort(end);
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int person = people[i];
            int p = binarySearch(start, person);
            int q = binarySearch(end, person);
            ans[i] = p - q;
        }
        
        return ans;
    }
}