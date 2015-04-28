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
    n >>>= 1;
  }
  ret *= 2;
  ret += n % 2;
  return ret >= 0 ? ret : -ret;
};
