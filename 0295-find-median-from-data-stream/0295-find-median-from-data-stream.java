class MedianFinder {
    PriorityQueue<Integer> leftPartition;
    PriorityQueue<Integer> rightPartition;
    
    public MedianFinder() {
        leftPartition = new PriorityQueue<>((a, b) -> b - a);
        rightPartition = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (leftPartition.size() == 0 || leftPartition.peek() > num) {
            leftPartition.add(num);
        } else {
            rightPartition.add(num);
        }
        
        if (Math.abs(leftPartition.size() - rightPartition.size()) > 1) {
            rightPartition.add(leftPartition.poll());
        } else if (leftPartition.size() < rightPartition.size()) {
            leftPartition.add(rightPartition.poll());
        }
    }
    
    public double findMedian() {
        if (leftPartition.size() == rightPartition.size()) {
            return (double)(leftPartition.peek() + rightPartition.peek()) / 2.0;
        }
        return (double)(leftPartition.peek());
    }
}