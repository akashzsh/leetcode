class StockSpanner {
    Stack<int[]> stk;

    public StockSpanner() {
        stk = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!stk.isEmpty() && price >= stk.peek()[0]) {
            span += stk.peek()[1];
            stk.pop();
        }
        stk.push(new int[]{price, span});
        return span;
    }
}