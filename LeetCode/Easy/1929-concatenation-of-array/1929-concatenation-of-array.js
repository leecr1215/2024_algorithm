/**
 * @param {number[]} nums
 * @return {number[]}
 */
var getConcatenation = function(nums) {
    let len = nums.length * 2;
    let arr = new Array(len);

    for(let i = 0; i < len; i++){
        arr[i] = nums[i % nums.length];
    }

    return arr;
};