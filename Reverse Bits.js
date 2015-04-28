/**
 * Solution to https://leetcode.com/problems/reverse-bits/
 *
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
  var ret = 0;
  for(var i=1; i<32; i++) {
    ret <<= 1;
    ret += n % 2;
    // be careful to use unsigned shift-right here
    n >>>= 1;
  }
  // Since JavaScript doesn't have unsigned shift-left,
  // we have to use * to prevent from changing the sign bit
  ret *= 2;    
  ret += n % 2;
  return ret;
};
