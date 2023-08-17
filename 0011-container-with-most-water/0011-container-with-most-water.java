class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1, water = 0;
        while (left < right) {
            int currWater = (right - left) * Math.min(height[left], height[right]);
            water = Math.max(water, currWater);
            if (height[left] < height[right]) left += 1;
            else right -= 1;
        }
        return water;
    }
}