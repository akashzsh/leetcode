class Solution {
    
    public void swap(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public int[][] flipAndInvertImage(int[][] image) {
        int rows = image.length;
        for (int i = 0; i < rows; i++) {
            swap(image[i], 0, rows - 1);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
        }
        return image;
    }
}