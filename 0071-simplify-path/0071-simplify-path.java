class Solution {
    public String simplifyPath(String path) {
        String[] pts = path.split("/");
        // System.out.println(Arrays.toString(pts));
        Stack<String> stk = new Stack<>();
        
        for (int i = 0; i < pts.length; i++) {
            
            if (!pts[i].equals("") && !pts[i].equals(" ") && !pts[i].equals("..") && !pts[i].equals(".")) {
                stk.push(pts[i]);
            } else if (pts[i].equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            }
        }
        // System.out.println(stk);
        StringBuilder sb = new StringBuilder();
        
        while (!stk.isEmpty()) {
            sb.insert(0, stk.pop());
            sb.insert(0, "/");
        }
        // System.out.println(sb);
        return sb.length() == 0 ? "/" : sb.toString();
    }
}


// [, home, , foo]