/**
 * My O(1)-space solution to https://leetcode.com/problems/set-matrix-zeroes/
 * Runtime: 264 ms
 */

public class Solution {
  public void setZeroes(int[][] matrix) {

    if (matrix.length==0 || matrix[0].length==0)  return;

    boolean zero_first_row = false;

    // Does the first row have zero?
    for(int j=0; j<matrix[0].length; ++j) {
      if(matrix[0][j]==0) {
        zero_first_row = true;
        break;
      }
    }

    // find zeroes and put marks in the first row
    for(int i=1; i<matrix.length; ++i) {
      int k = matrix[0].length;
      for(int j=0; j<matrix[0].length; ++j) {
        if(matrix[i][j] == 0) {
          matrix[0][j] = k = 0;   // mark this column
        }
      }
      while(k<matrix[0].length)
        matrix[i][k++] = 0;
    }

    // zero the marked columns
    for(int j=0; j<matrix[0].length; ++j) {
      if(matrix[0][j] == 0)
        for(int k=1; k<matrix.length; ++k)
          matrix[k][j] = 0;
    }

    // zero the first row and if needed
    if (zero_first_row)
      for (int j=0; j<matrix[0].length; ++j)
        matrix[0][j] = 0;
  }
}
