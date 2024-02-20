class Solution {

    public static boolean isAlphabet(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch  <= 'z');
    }

    public static void generate(int idx, String s, List<String> res, String vec) {
        if (idx == s.length()) {
            res.add(vec);
            return;
        }

        if (isAlphabet(s.charAt(idx))) {
            generate(idx + 1, s, res, vec + Character.toLowerCase(s.charAt(idx)));
            generate(idx + 1, s, res, vec + Character.toUpperCase(s.charAt(idx)));
        } else {
            generate(idx + 1, s, res, vec + s.charAt(idx));
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();

        generate(0, s, res, "");

        return res;
    }
}