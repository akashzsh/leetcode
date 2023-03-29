class Solution {
    public double[] convertTemperature(double celsius) {
        double fahrenheit = celsius * 1.8 + 32;
        double kelvin = celsius + 273.15;
        double[] ans = {kelvin, fahrenheit};
        return ans;
    }
}