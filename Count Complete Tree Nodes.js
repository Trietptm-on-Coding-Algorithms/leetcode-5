/**
 * This is my solution to problem https://leetcode.com/submissions/detail/30177465/
 * It has the shortest running time among all JavaScript, Java and Python AC submissions to this problem!
 *
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var countNodes = function(node) {
    if(!node) return 0;
    var right_height = h1(node.right);
    var left_height = h1(node.left);
    if(left_height == right_height) {
        var c = Math.pow(2, left_height);
        if(h2(node.right) == right_height)
            return 2*c - 1; // node is full
        else
            return c + countNodes(node.right);
    }
    if(left_height > right_height) {
        var c = Math.pow(2, left_height - 1);
        if(h2(node.left) == left_height)
            return 3*c - 1; // node.left is full
        else
            return c + countNodes(node.left);
    }
    throw "node is not a complete tree!";
};
function h1(node) {
    if(!node) return 0;
    if(node.h1) return node.h1;
    var ret = 1;
    var n = node;
    while(n.left) {
        n = n.left;
        ret++;
    }
    var r = ret;
    while(node.left) {
        node.h1 = r;
        node = node.left;
        r--;
    }
    return ret;
}
function h2(node) {
    if(!node) return 0;
    if(node.h2) return node.h2;
    var ret = 1;
    var n = node;
    while(n.right) {
        n = n.right;
        ret++;
    }
    var r = ret;
    while(node.right) {
        node.h2 = r;
        node = node.right;
        r--;
    }
    return ret;
}
