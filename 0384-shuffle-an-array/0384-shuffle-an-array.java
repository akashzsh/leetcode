class Solution {
    private int[] array;
    private int[] original;
    Random r = new Random();
    
    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }
    
    public int[] shuffle() {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            swap(i, r.nextInt(i, (n - i) + i));
        }
        return array;
    }
}