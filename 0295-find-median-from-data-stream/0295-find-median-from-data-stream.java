class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>();
    
    public MedianFinder() {}
    
    public void addNum(int num) {
        if (left.size() == 0 || left.peek() > num) {
            left.add(num);
        } else {
            right.add(num);
        }
        
        if (Math.abs(left.size() - right.size()) > 1) {
            right.add(left.poll());
        } else if (left.size() < right.size()) {
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return (double)(left.peek() + right.peek()) / 2;
        } else {
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */