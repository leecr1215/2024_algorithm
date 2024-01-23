/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let newArr = [];
    
    arr.forEach((number, idx)=>{
        newArr.push(fn(number, idx));
    });
    
    return newArr;
};