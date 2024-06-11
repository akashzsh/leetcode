class MedianFinder {
public:
    priority_queue<int> lf;
    priority_queue<int, vector<int>, greater<int>> rt;
    
    MedianFinder() {}
    
    void addNum(int num) {
        if (lf.empty() || num <= lf.top()) {
            lf.push(num);
        } else {
            rt.push(num);
        }
        
        if (lf.size() > 1 + rt.size()) {
            rt.push(lf.top()); lf.pop();
        } else if (rt.size() > lf.size()) {
            lf.push(rt.top()); rt.pop();
        }
    }
    
    double findMedian() {
        if ((lf.size() + rt.size()) & 1) {
            return double(lf.top());
        } else {
            return double(lf.top() + rt.top()) / 2.0;
        }
    }
};