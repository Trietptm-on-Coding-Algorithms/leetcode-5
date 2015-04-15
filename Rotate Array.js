/**
 * Solutions to https://leetcode.com/problems/rotate-array/
 *
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */

/**
 * This algorithm runs in O(n) time and O(1) space.
 * It runs faster than 95% of all JS submissions on Leetcode.
 */
var rotate = function(nums, k) {
    k = k % nums.length
    if(nums.length<=1 || !k)
        return
    function rev(from, end)  {
        var to = end - 1
        if(from >= to)
            return
        for(var i=0, n=(to-from)/2; i<n; i++) {
            var t = nums[from + i]
            nums[from + i] = nums[to - i]
            nums[to - i] = t
        }
    }
    rev(0, nums.length)
    rev(0, k)
    rev(k, nums.length)
}

/**
 * This algorithm runs in O(n) time and O(1) space.
 * The idea is trace each cyclic group in the shift
 * (numbered by nextGroup variable).
 */
var rotate = function(nums, k) {
 k = k % nums.length
 if(nums.length<=1 || !k)
    return
  var from = 0
  var val = nums[from]
  var nextGroup = 1
  for(var i=0; i<nums.length; i++) {
    var to = (from + k) % nums.length
    if(to == from)
      break

    var t = nums[to]
    nums[to] = val
    from = to
    val = t

    if(from < nextGroup) {
      from = nextGroup++
      val = nums[from]
    }
  }
}
