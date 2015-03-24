public class Solution {
    /** 
     * This is a O(n) algorithm for finding the area of the largest rectangle
     * in histogramand and is a simple version of Daveed V's optimal algorithm 
     * for finding the largest rectangle in a 2D matrix.
     * See https://gist.github.com/ericpony/15c1a126980f36652e6a for details.
     */
    public int largestRectangleArea(int[] height) {
        
        if(height==null || height.length==0)
            return 0;
            
        int[] stack = new int[height.length];
        int[] pos = new int[height.length];
        int top = -1;
        int maxRectArea = 0;
        
        for(int i=0; i<=height.length; i++) {
            /**
            * Setting h to 0 would pop all bars in the stack.
            */
            int h = i<height.length ? height[i] : 0;
            
            /**
             * Push a higher bar to stack.
             */ 
            if(top<0 || h>stack[top]) {
                top++;
                stack[top] = h;
                pos[top] = i;
                continue;
            }
            /**
             * We don't need this bar, since we have recorded 
             * the position of the leftmost bar of the same height.
             */ 
            if(h==stack[top]) {
                continue;
            }
            /**
             * Once we meet a lower bar, pop every bars left to the
             * bar that cannot form rectangles with bars right to it.
             */ 
            while(top>=0 && h<=stack[top]) {
                int rectArea = (i-pos[top])*stack[top];
                maxRectArea = Math.max(rectArea, maxRectArea);
                top--;
            }
            /**
             * Push the lower bar to stack. Note that the position
             * of the newly pushed bar is already set at pos[top].
             */ 
            stack[++top] = h;
        }
        return maxRectArea;
    }
}