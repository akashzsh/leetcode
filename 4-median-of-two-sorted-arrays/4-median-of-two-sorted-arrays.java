import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int[] mergedArray = new int[length1 + length2];
        int index = 0;
        
        for (int i = 0; i < length1; i++) mergedArray[index++] = nums1[i];
        for (int i = 0; i < length2; i++) mergedArray[index++] = nums2[i];
        Arrays.sort(mergedArray);
        
        int middle = mergedArray.length / 2;
        
        if (mergedArray.length % 2 != 0) return mergedArray[middle];
        
        return (double) (mergedArray[middle] + mergedArray[middle - 1]) / 2;
    }
}