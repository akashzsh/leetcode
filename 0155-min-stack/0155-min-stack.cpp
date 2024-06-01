class MinStack {
public:
    typedef long long ll;
    
    stack<ll> st;
    ll minimum;
    
    MinStack() {
        minimum = LONG_MAX;
    }
    
    void push(int value) {
        // ll value = cur;
        if (st.empty()) {
            st.push(value);
            minimum = value;
        } else {
            if (value < minimum) {
                st.push((ll)value * 2 - minimum);
                minimum = value;
            } else {
                st.push(value);
            }
        }
    }
    
    void pop() {
        ll cur = st.top();
        st.pop();
        
        if (cur < minimum) {
            minimum = 2 * minimum - cur;
        }
    }
    
    int top() {
        ll cur = st.top();
        
        if (cur < minimum) {
            return minimum;
        } else {
            return cur;
        }
    }
    
    int getMin() {
        return minimum;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */