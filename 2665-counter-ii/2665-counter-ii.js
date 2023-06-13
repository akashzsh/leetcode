/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let current = init;
    
    function increment() {
        return ++current;
    }
    
    function decrement() {
        return --current;
    }
    
    function reset() {
        return (current = init);
    }
    
    return {increment, decrement, reset};
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */