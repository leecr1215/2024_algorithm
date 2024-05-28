function getRank(cnt){
    if(cnt < 1) return 6;
    return 7 - cnt;
}

function solution(lottos, win_nums) {
    let nums = new Array(46).fill(0);
    let sameCnt = 0;
    let zeroCnt = 0;
    
    lottos.forEach((lotto)=>{
        if(lotto === 0) zeroCnt++;
        nums[lotto] = 1;
    });
    
    win_nums.forEach((win_num)=>{
        if(nums[win_num]===1) sameCnt++;
    })
    
    let curRank = getRank(sameCnt);
    console.log(sameCnt, curRank, zeroCnt);
    
    let bestRank = curRank - zeroCnt < 1 ? 1 : curRank - zeroCnt;
   
    return [bestRank, curRank];
}