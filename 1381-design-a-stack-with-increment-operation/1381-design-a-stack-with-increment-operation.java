class CustomStack {
    int n;
    Stack<Integer> st;
    int[] mark;
    
    public CustomStack(int maxSize) {
        n = maxSize;
        st = new Stack<>();
        mark = new int[n];
    }
    
    public void push(int x) {
        if (st.size() < n) {
            st.push(x);
        }
    }
    
    public int pop() {
        int j = st.size() - 1;
        if (j < 0) {
            return -1;
        }
        if (j > 0) {
            mark[j - 1] += mark[j];
        }
        int val = st.pop() + mark[j];
        mark[j] = 0;
        return val;
    }
    
    public void increment(int k, int val) {
        int v = Math.min(k, st.size()) - 1;
        if (v >= 0) {
            mark[v] += val;
        }
    }
}