function leftRightDifference(nums: number[]): number[] {
    const n = nums.length;
    let leftSum = Array(n).fill(0);
    let rightSum = Array(n).fill(0);

    for(let i = 1; i < n; i++){
        leftSum[i] = leftSum[i-1] + nums[i-1];
        rightSum[n-1-i] = rightSum[n-i] + nums[n-i];
    }


    let answer = Array(n);

    for(let i = 0; i < n; i++){
        answer[i] = Math.abs(leftSum[i]-rightSum[i]);
    }

    return answer;
};