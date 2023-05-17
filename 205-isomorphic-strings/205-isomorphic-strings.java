class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[128];
        int[] m2 = new int[128];
        Arrays.fill(m1, 0);
        Arrays.fill(m2, 0);
        for (int i = 0; i < s.length(); i++) {
            if (m1[(int) s.charAt(i)] != m2[(int) t.charAt(i)]) return false;
            m1[(int) s.charAt(i)] = m2[(int) t.charAt(i)] = i + 1;
        }
        return true;
    }
}