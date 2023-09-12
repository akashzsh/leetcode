class Solution {
    double x, y, radius;

    public Solution(double radius, double x_center, double y_center) {
        this.x = x_center;
        this.y = y_center;
        this.radius = radius;
    }
    
    public double[] randPoint() {
        double length = Math.sqrt(Math.random()) * radius;
        double angle = 2 * Math.PI * Math.random();
        return new double[]{x + length * Math.cos(angle), y + length * Math.sin(angle)};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */