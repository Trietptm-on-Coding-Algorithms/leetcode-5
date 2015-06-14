Array.prototype.peek = function() {
    return this[this.length - 1];
}
/**
 * @param {string} s
 * @return {number}
 */
var calculate = function(str) {
    if(!str || !str.length)
        return 0;
    var signs = [1, 1]; // the sign of the current parentheses
    var ret = 0;
    var sign = 1;
    for(var i=0; i<str.length;) {
        while(str[i] == ' ') i++;
        var j = i;
        while(str[i]>='0' && str[i]<='9') i++;
        if(i > j) {
            ret += signs.pop() * parseInt(str.substr(j, i));
            continue;
        }
        switch(str[i]) {
            case '+': signs.push(signs.peek() *  1); break;
            case '-': signs.push(signs.peek() * -1); break;
            case '(': signs.push(signs.peek());      break;
            case ')': signs.pop();                   break;
        }
        i++;
    }
    return ret;
};
