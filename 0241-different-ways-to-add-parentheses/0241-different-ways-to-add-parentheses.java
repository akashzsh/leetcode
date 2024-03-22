class Solution {
    public int operate(Integer a, Integer b, char ch) {
        switch(ch) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            default:
                return a * b;
        }
    }
    
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        boolean isNumber = true;
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                isNumber = false;
                
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, n));
                
                for (Integer x : left) {
                    for (Integer y : right) {
                        res.add(operate(x, y, expression.charAt(i)));
                    }
                }
            }
        }
        
        if (isNumber) {
            res.add(Integer.parseInt(expression));
            return res;
        }
        
        return res;
    }
}