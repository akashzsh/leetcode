class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len = v1.length > v2.length ? v1.length : v2.length;
        
        for (int i = 0; i < len; i++) {
            Integer e1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            Integer e2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            int res = e1.compareTo(e2);
            if (res != 0) {
                return res;
            }
        }
        
        return 0;
    }
}