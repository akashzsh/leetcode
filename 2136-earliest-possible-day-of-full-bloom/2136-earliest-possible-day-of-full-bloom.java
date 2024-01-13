class Seed {
    int plant;
    int grow;
    
    Seed(int plant, int grow) {
        this.plant = plant;
        this.grow = grow;
    }
}

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Seed[] seeds = new Seed[n];
        for (int i = 0; i < n; i++) {
            seeds[i] = new Seed(plantTime[i], growTime[i]);
        }
        Arrays.sort(seeds, (a, b) -> b.grow - a.grow);
        int res = 0, prevPlantDays = 0;
        for (int i = 0; i < n; i++) {
            int curPlantDays = seeds[i].plant;
            int curGrowDays = seeds[i].grow;
            
            prevPlantDays += curPlantDays;
            res = Math.max(res, prevPlantDays + curGrowDays);
        }
        return res;
    }
}