class Solution {
    public String interpret(String command) {
        String result = "";
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') result += 'G';
            else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                result += 'o';
                i++;
            }
            else {
                result += "al";
                i += 3;
            }
        }
        return result;
    }
}