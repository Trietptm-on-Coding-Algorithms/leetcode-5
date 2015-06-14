/**
 * @param {number} A
 * @param {number} B
 * @param {number} C
 * @param {number} D
 * @param {number} E
 * @param {number} F
 * @param {number} G
 * @param {number} H
 * @return {number}
 */
var computeArea = function(A, B, C, D, E, F, G, H) {
    var left_y  = Math.max(B,F);
    var right_y = Math.min(D,H);
    var left_x  = Math.max(A,E);
    var right_x = Math.min(C,G);

    var height = Math.max(right_y - left_y, 0);
    var width  = Math.max(right_x - left_x, 0);

    return (C-A)*(D-B) + (G-E)*(H-F) - width*height;
};
