/**
 * Solution to https://github.com/ericpony/leetcode
 */
/**
 * @constructor
 */
var MinStack = function() {
    this.stack = [];
    this.min = [];
};

Array.prototype.peek = function() {
    return this[this.length-1];
};

/**
 * @param {number} x
 * @returns {void}
 */
MinStack.prototype.push = function(x) {
    this.stack.push(x);
    if(this.min.length)
        this.min.push(Math.min(this.min.peek(), x));
    else
        this.min.push(x);
};

/**
 * @returns {void}
 */
MinStack.prototype.pop = function() {
    this.min.pop();
    return this.stack.pop();
};

/**
 * @returns {number}
 */
MinStack.prototype.top = function() {
    return this.stack.peek();
};

/**
 * @returns {number}
 */
MinStack.prototype.getMin = function() {
    return this.min.peek();
};
