public class Solution {
    /**
     * This is a Java implementation of Daveed Vandevoorde's optimal solution 
     * (linear time & space) to the discrete Maximal Rectangle Problem.
     * See http://www.drdobbs.com/database/the-maximal-rectangle-problem/184410529
     * for problem description and details of algorithm. Also see
     * https://gist.github.com/ericpony/0cb44996f43334ed28dc for a simpler variant 
     * of this problem.
     */ 
    public int maximalRectangle(char[][] matrix) {
      
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
            
        int maxRectArea = 0;
        int[][] marks = new int[matrix.length][matrix[0].length];
        int[] stack = new int[matrix.length];
        int[] pos = new int[matrix.length];
        int top = -1; // index of the top element of the stack
        
        /**
         * Marking the number of consecutive 1's (left to right) row by row.
         * For example, if the ith row of the matrix is {0,1,1,0,1,0,1,1,1},
         * then the ith row of the marks should be {0,1,2,0,1,0,1,2,3}.
         */
        for(int i=0; i<matrix.length; i++) {
            marks[i][0] = matrix[i][0]=='1' ? 1 : 0;
            for(int k=1; k<matrix[i].length; k++) 
                marks[i][k] = matrix[i][k]=='1' ? marks[i][k-1]+1 : 0;
        }
        /**
         * Scan the matrix column by column to compute maxRectArea
         */ 
        for(int j=0; j<matrix[0].length; j++) { // column            
            for(int i=0; i<=matrix.length; i++) { // row
                
                int len = (i==matrix.length||matrix[i][j]=='0') ? 0 : marks[i][j];                
                
                if(len>0 && (top<0 || stack[top]<len)) {
                    top++;
                    pos[top] = i;
                    stack[top] = len; // push
                    continue;
                }
                
                if(len>0 && stack[top]==len)
                	continue;
                /**
                 * Note that each element of the matrix is pop/pushed at most 
                 * once. Hence the total overheads caused by stack operations
                 * is linear in the size of the matrix.
                 */
                while(top>=0 && stack[top]>=len) {
                    int currRectArea = (i-pos[top])*stack[top];
                    maxRectArea = Math.max(maxRectArea, currRectArea);
                    top--;  // pop
                }
                
                if(len==0) 
                    top = -1; // reset stack                    
                else
                    stack[++top] = len; // push
            }
        }
        return maxRectArea;
    }
}