function Queue() {

  var queue  = [];
  var offset = 0;

  this.getLength = function() {
    return (queue.length - offset);
  }

  this.isEmpty = function() {
    return (queue.length === 0);
  }

  this.enqueue = function(item) {
    queue.push(item);
  }

  this.dequeue = function() {
      if (queue.length === 0) return undefined;
      var item = queue[offset++];
      if (offset*2 >= queue.length) {
        queue  = queue.slice(offset);
        offset = 0;
      }
      return item;
  }

  this.peek = function() {
    return (queue.length > 0 ? queue[offset] : undefined);
  }
}

/**
 * @constructor
 */
var Stack = function() {
    this.queue = new Queue();
};

/**
 * @param {number} x
 * @returns {void}
 */
Stack.prototype.push = function(x) {
    this.queue.enqueue(x)
    for(var i=1, n=this.queue.getLength(); i<n; i++) {
        x = this.queue.dequeue();
        this.queue.enqueue(x);
    }
};

/**
 * @returns {void}
 */
Stack.prototype.pop = function() {
    return this.queue.dequeue();
};

/**
 * @returns {number}
 */
Stack.prototype.top = function() {
    return this.queue.peek();
};

/**
 * @returns {boolean}
 */
Stack.prototype.empty = function() {
    return this.queue.isEmpty();
};
