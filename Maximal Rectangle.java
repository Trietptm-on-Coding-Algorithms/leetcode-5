/**
 * My optimal O(n) solution to https://leetcode.com/problems/maximal-rectangle/
 *
 */
public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int maxRectArea = 0;
        int[][] marks = new int[matrix.length][matrix[0].length];
        int[] stack = new int[matrix.length];
        int[] pos = new int[matrix.length];
        int top = -1; // index of the top element in the stack
        /**
         * Marking the number of consecutive 1's (left to right).
         * in the rows. E.g., if the ith row of matrix is {0,1,1,0,1,0,1,1,1},
         * then the ith row of marks should be {0,2,1,0,1,0,3,2,1}.
         * */
        for(int i=0; i<matrix.length; i++) {
            int t = matrix[i].length;
            marks[i][t-1] = matrix[i][t-1]=='1' ? 1 : 0;
            for(int k = t-2; k>=0; k--)
                marks[i][k] = matrix[i][k]=='1' ? marks[i][k+1]+1 : 0;
        }

        for(int j=0; j<matrix[0].length; j++) { // column
            for(int i=0; i<=matrix.length; i++) { // row

                int len = (i==matrix.length||matrix[i][j]=='0') ? 0 : marks[i][j];

                if(len>0 && (top<0 || stack[top]<len)) {
                	top++;
                	pos[top] = i;
                    stack[top] = len;
                    continue;
                }

                if(len>0 && top>=0 && stack[top]==len)
                	continue;

                while(top>=0 && stack[top]>=len) {
                	int currRectArea = (i-pos[top])*stack[top];
                    maxRectArea = Math.max(maxRectArea, currRectArea);
                    top--;
                }

                if(len==0)
                    top = -1; // reset stack
                else
                    stack[++top] = len;
            }
        }
        return maxRectArea;
    }
}
