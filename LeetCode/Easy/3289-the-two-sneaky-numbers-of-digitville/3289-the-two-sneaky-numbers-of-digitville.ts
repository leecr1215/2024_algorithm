function getSneakyNumbers(nums: number[]): number[] {
    let cnts = Array(nums.length).fill(0);

    let answer = [];

    nums.forEach(num => {
        cnts[num]++;

        if(cnts[num] >=2) answer.push(num);
    })

    return answer;
};