class Solution {
    public List<String> buildArray(int[] target, int n) {
        int len = target.length;
        List<String> res = new ArrayList<>();
        int p = 0, i = 1;
        Stack<Integer> st = new Stack<>();
        while (p < len) {
            st.push(i);
            res.add("Push");
            if (st.peek() != target[p]) {
                st.pop();
                res.add("Pop");
                p--;
            }
            p++;
            i++;
        }
        return res;
    }
}