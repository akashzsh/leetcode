class ParkingSystem {
    int[] space = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        space[0] = big;
        space[1] = medium;
        space[2] = small;
    }
    
    public boolean addCar(int carType) {        
        if (carType == 1 && space[0] > 0) {
            space[0] -= 1;
            return true;
        }
        if (carType == 2 && space[1] > 0) {
            space[1] -= 1;
            return true;
        }
        if (carType == 3 && space[2] > 0) {
            space[2] -= 1;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */