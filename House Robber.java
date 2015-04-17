/**
 * An optimal solution to https://leetcode.com/problems/house-robber/
 */
public class Solution {
  public int rob(int[] num) {
    int n = num.length;
    if(n==0) return 0;
    if(n==1) return num[0];
    int[] B = new int[n];
    B[0] = num[0];
    B[1] = Math.max(num[0], num[1]);
    for(int i=2; i<n; i++) {
      B[i] = Math.max(num[i] + B[i-2], B[i-1]);
    }
    return B[n-1];
  }
}
