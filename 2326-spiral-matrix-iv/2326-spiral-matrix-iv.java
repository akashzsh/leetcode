class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        ListNode current = head;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[top][i] = current == null ? -1 : current.val;
                if (current != null) current = current.next;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = current == null ? -1 : current.val;
                if (current != null) current = current.next;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = current == null ? -1 : current.val;
                    if (current != null) current = current.next;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = current == null ? -1 : current.val;
                    if (current != null) current = current.next;
                }
                left++;
            }
        }
        return result;
    }
}