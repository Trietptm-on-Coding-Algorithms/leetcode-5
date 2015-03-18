/**
 * My O(n) solution to https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Runtime: 266 ms
 */
public class Solution {
    public int longestConsecutive(int[] num) {
        Arrays.sort(num);
        int max_len = 0;
        int current_len = num.length>0 ? 1 : 0;
        for(int i=0;i<num.length-1;i++)
        {
            switch(num[i+1]-num[i]) {
                case 0: continue;
                case 1: current_len++; break;
                default:
                    max_len = Math.max(current_len, max_len);
                    current_len = 1;
            }
        }
        return Math.max(current_len, max_len);
    }
}
