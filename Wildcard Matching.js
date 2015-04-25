/**
 * Some solutions to https://leetcode.com/problems/wildcard-matching/
 * 
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
 
/** 
 * https://leetcode.com/discuss/10133/linear-runtime-and-constant-space-solution 
 */
var isMatch = function(s, p) {
  var ss = sss = pp = 0;
  var ppp = -1;
  while(ss<s.length) {
    // either both characters match, or '?' is found in pattern:
    if(p[pp]=='?' || s[ss]==p[pp]) {
      // advancie both pointers. 
      pp++;
      ss++;
      continue;
      // Note that pp will not advance beyond p's length. 
    }
    // found * in pattern:
    if(p[pp] == '*') {
      // track the index of '*' and advance pattern pointer 
      sss = ss;
      ppp = pp;
      pp++;
      continue;
    }
    // current characters didn't match, last pattern pointer was '*', current pattern pointer is not '*'
    if(p[ppp]) {
      // only advance string pointer
      pp = ppp + 1;
      ss = sss + 1;
      sss++;
      continue;
    }
    // current pattern pointer is not '*', last patter pointer was not '*'
    return false;
    // character doesn't match
  }
  // check remaining characters in pattern
  while(p[pp] == '*') pp++;
  
  // whether all characters are matched
  return pp == p.length;
};

var isMatch_cheat = function(s, p) {
  var ptn = pattern.replace(/\?/g,'.').replace(/\*+/g,".*");
  var reg = new RegExp(ptn);
  return reg.test(str);
};

var isMatch_TLE = function(s, p) {
  // M[i] = { boolean: p[0..j-1] matches s[0..i-1] }
  // M[0][0] is set to true
  var M = [[true]]; 
  var p_len = p.length;
  var s_len = s.length;
  for(var i=1; i<=p_len; i++) {
    M[i] = [];
    switch(p[i]) {
      case '*':
        for(var j=0, t=false; j<=s_len; j++) {
          t = t || M[i-1][j];
          M[i][j] = t;
        }
        break;
      case '?':
        for(var j=1; j<=s_len; j++) {
          M[i][j] = M[i-1][j-1];
        }
        break;        
      default:
        var c = p[i];
        for(var j=1; j<=s_len; j++) {
          M[i][j] = M[i-1][j-1] && (s[j]==c);
        }
        break;
    }
  }
  return !!M[p_len][s_len];
};
