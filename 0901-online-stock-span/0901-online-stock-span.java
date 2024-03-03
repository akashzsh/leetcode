class StockSpanner {
    Stack<int[]> stk;

    public StockSpanner() {
        stk = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        while (!stk.isEmpty() && stk.peek()[0] <= price) {
            span = span + stk.pop()[1];
        }
        
        stk.push(new int[]{price, span});
        return span;
    }
}