class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0, trails = minutesToTest / minutesToDie + 1;
        while (Math.pow(trails, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}