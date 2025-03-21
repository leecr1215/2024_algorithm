/**
 * @param {number[]} nums
 * @return {number[]}
 */
var buildArray = function(nums) {
    let answer = new Array(nums.length);

    for(let i = 0; i < nums.length; i++){
        answer[i] = nums[nums[i]];
    }

    return answer;
};