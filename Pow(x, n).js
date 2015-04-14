/**
 * Solution to https://leetcode.com/problems/powx-n/
 *
 * @param {number} x float base
 * @param {number} n integer exponent
 * @return {number}
 */

/* Ver1: Fastest version */
var pow = function(x, n) {
  if(x===0 || n===1) return x
  if(n < 0) {
    n = -n
    x = 1/x
  }
  var ret = 1
  var m = x
  while(n > 0) {
    if(n % 2) ret *= m
    m *= m
    n >>= 1
  }
  return ret
}

/* Ver2: Recursive version */
var pow = function(x, n) {
  if(n===0) return 1
  if(x===0) return 0
  if(n < 0) return pow(1/x, -n)
  var ret = pow(x, n>>1);
  if(n % 2)
    return ret * ret * x
  else
    return ret * ret
}

/* Ver3: Purely functional version  */
/* Note: slightly faster than Ver2! */
var pow = function(x, n) {
  if(n===0) return 1
  if(x===0) return 0
  if(n < 0) return pow(1/x, -n)
  return (function(ret, n, x) {
   if(n % 2)
     return ret * ret * x
   else
     return ret * ret
  })(pow(x, n>>1), n, x)
}

