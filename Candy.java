/**
 * Strategy:
 * 1. First ignore some requirements and give a quick solution.
 * 2. Put constraints back and polish the quick solution accordingly.
 * 
 * In the following program, the quick solution is 
 *      candy[i] = 1 + (ratings[i]>ratings[i-1]?) candy[i-1] : 0
 * where candy[i] is the number of candies given to the ith child,
 * and the constraints are the lower-bounds for each candy[i].
 * 
 * Other points are: 
 * 1. building the lower-bounds in one phase, and
 * 2. noting that we can give adjacent children different number
 * of candies even though they have the same ratings.
 * 
 **/

public class Solution {
    public int candy(int[] ratings) {
        int[] lwrbnds = new int[ratings.length];
        lwrbnds[lwrbnds.length-1] = 1;
        
        for(int lwrbnd=1, i=ratings.length-1; i>=1; i--) {
            if(ratings[i-1]>ratings[i])
                lwrbnds[i-1] = ++lwrbnd;
            else
                lwrbnds[i-1] = lwrbnd = 1;
        }
        
        int candy = Math.max(1, lwrbnds[0]);
        int num_candies = candy;
        
        for(int i=1; i<ratings.length; i++) {
            if(ratings[i]>ratings[i-1])
                candy = Math.max(candy+1, lwrbnds[i]);
            else 
                candy = lwrbnds[i];
            num_candies += candy;
        }
        return num_candies;
    }
}
