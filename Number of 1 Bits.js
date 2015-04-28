/**
 * Solution to https://leetcode.com/problems/number-of-1-bits/
 *
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
  var ret = 0;
  while(n>0) { 
    ret += n % 2;
    n >>>= 1;
  }
  return ret;
}
