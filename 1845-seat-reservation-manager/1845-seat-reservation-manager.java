class SeatManager {
    int marker;
    TreeSet<Integer> ts;
    
    public SeatManager(int n) {
        marker = 1;
        ts = new TreeSet<>();
    }
    
    public int reserve() {
        if (!ts.isEmpty()) {
            int cur = ts.pollFirst();
            return cur;
        }
        int cur = marker;
        marker++;
        return cur;
    }
    
    public void unreserve(int seatNumber) {
        ts.add(seatNumber);
    }
}