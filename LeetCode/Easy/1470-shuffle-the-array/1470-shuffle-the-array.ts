function shuffle(nums: number[], n: number): number[] {
    let answer = [];

    for(let i = 0; i < n; i++){
        answer.push(nums[i]);
        answer.push(nums[i+n]);
    }

    return answer;
};