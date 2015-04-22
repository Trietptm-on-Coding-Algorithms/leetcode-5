/**
 * My solution to https://leetcode.com/problems/word-break/
 *
 * @param {string} s
 * @param {set<string>} wordDict
 * @return {boolean}
 */
var wordBreak_v0 = function(s, wordDict) {
  if(wordDict.has(s)) return true;
  // B[i][j] = {s.substring(i,j+1) is in dictionary}
  var B = [];
  for(var i=0; i<s.length; i++) {
    B[i] = [];
    for(var j=i; j<s.length; j++) {
      B[i][j] = wordDict.has(s.substring(i, j+1));
    }
  }
  var changed = true;
  while(changed) {
    changed = false;
    for(var i=0; i<s.length; i++) {
      for(var j=i; j<s.length; j++) {
        if(B[i][j]) continue;
        for(var k=i; k<j; k++) {
          if(B[i][k] && B[k+1][j]) {
            changed = B[i][j] = true;
          }
        }
      }
      if(B[0][s.length-1]) return true;
    }
  }
  return B[0][s.length-1];
};

var wordBreak_v1 = function(s, wordDict) {
  if(wordDict.has(s)) return true;
  // B[n][i] = {s.substr(i,n) is in dictionary}
  var B = [];
  for(var n=1; n<=s.length; n++) {
    B[n] = B[n] || [];
    for(var j=0; j+n<=s.length; j++) {
      B[n][j] = wordDict.has(s.substr(j, n));
      if(B[n][j]) continue;
      for(var m=1; m<n; m++) {
        if(B[m][j] && B[n-m][j+m]) {
          B[n][j] = true;
          break;
        }
      }
    }
  }
  return B[s.length][0];
};
