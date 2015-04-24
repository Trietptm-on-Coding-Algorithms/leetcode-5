/**
 * My solution to https://leetcode.com/problems/compare-version-numbers/
 *
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function(version1, version2) {
    var ver1 = version1.split('.');
    var ver2 = version2.split('.');
    var len = Math.min(ver1.length, ver2.length);
    for(var i=0; i<len; i++) {
        var v1 = parseInt(ver1[i]);
        var v2 = parseInt(ver2[i]);
        if(v2 < v1) return 1;
        if(v1 < v2) return -1;
    }
    if(ver1.length > ver2.length) {
        while(i < ver1.length)
            if(ver1[i++] != 0) return 1;
        return 0;
    }
    if(ver2.length > ver1.length) {
        while(i < ver2.length)
            if(ver2[i++] != 0) return -1;
        return 0;
    }
    return 0;
};
