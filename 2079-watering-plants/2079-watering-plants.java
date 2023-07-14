class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int len = plants.length, steps = 0, currStep = 0, old = capacity;
        while (currStep != len) {
            if (plants[currStep] <= capacity) {
                capacity -= plants[currStep];
                currStep++;
                steps++;
            } else {
                capacity = old;
                steps += 2 * currStep;
            }
        }
        return steps;
    }
}