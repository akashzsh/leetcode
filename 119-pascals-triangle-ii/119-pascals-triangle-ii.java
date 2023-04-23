class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> row = null;
        for (int i = 0; i <= rowIndex; i++) {
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1);
                else row.add(pre.get(j - 1) + pre.get(j));
            }
            pre = row;            
            if (i == rowIndex) break;
        }
        return pre;
    }
}