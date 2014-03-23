import java.util.*;

public class Solution {
    
    public String reverseWords(String s) {
        // Which version is the fastest? I guess v3.
        return reverseWords_v3(s);
    }
    /**
     * Do everything from sketch, supposedly to be most efficient
     */
    public String reverseWords_v3(String s) {
        char[] buf = new char[s.length()+1];
        int pos = 0;
        for (int i = s.length()-1; i >= 0; ) {
            while (i>=0 && s.charAt(i)==' ') i--;
            if (i<0) break;
            if (pos>0) buf[pos++] = ' ';
            int j = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            int k = i+1;
            while (k<=j) buf[pos++] = s.charAt(k++);                     
        }
        // we have to discard zeros; otherwise the result would contain non-printable characters
        return new String(buf,0,pos);
    }

    /**
     * More time-efficient, double space 
     */
    public String reverseWords_v2(String s) {
        StringTokenizer st = new StringTokenizer(s);
        LinkedList<String> stk = new LinkedList<>();
        while (st.hasMoreTokens()) {
            stk.push(st.nextToken());
            stk.push(" ");
        }
        int len = stk.size();
        if (len>0) {
            stk.pop();
            StringBuilder sb = new StringBuilder(len-1); // we have exact len-1 tokens here
            while (--len>0) {
                sb.append(stk.pop());
            }
            return sb.toString();
        }
        return "";
    }
    
    /**
     * More space-efficient, simple logic
     */
    public String reverseWords_v1(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            sb.insert(0, st.nextToken()); // each insertion takes O(n) time
            sb.insert(0, ' ');
        }
        if(sb.length()>0) {
            sb.deleteCharAt(0); // each deletion takes O(n) time
        }
        return sb.toString();
    }    
}