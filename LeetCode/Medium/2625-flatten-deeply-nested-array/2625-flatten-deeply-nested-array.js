/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */

var flat = function (arr, n) {
    
    for(let i = 0; i < n; i++){
        arr = [].concat(...arr);
    }
    
    return arr;
};