class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> vec = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            vec.add(i);
            fact = fact * i;
        }
        vec.add(n);
        k = k - 1;
        String res = "";
        while (true) {
            res = res + Integer.toString(vec.get(k / fact));
            vec.remove(k / fact);
            if (vec.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / vec.size();
        }
        return res;
    }
}