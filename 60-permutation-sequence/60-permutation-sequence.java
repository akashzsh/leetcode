class Solution {
    public String getPermutation(int n, int k) {
        String res = "";
        int fact = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            arr.add(i);
        }
        arr.add(n);
        k = k - 1;
        while (true) {
            res += arr.get(k / fact);
            arr.remove(k / fact);
            if (arr.size() == 0) break;
            k = k % fact;
            fact = fact / arr.size();
        }
        return res;
    }
}