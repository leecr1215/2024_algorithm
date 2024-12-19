function solution(want, number, discount) {
    const mart = {};
    for(let i = 0; i < 10; i++){
        mart[discount[i]] = mart[discount[i]] === undefined ? 1 : mart[discount[i]]+1;
    }
    
    let start = 0;
    let end = 9;
    
    let result = 0;
    
    while(end <= discount.length - 1){
        if(isAllInclude(want, number, mart)) result++;
        
        //start 제외
        mart[discount[start]] -= 1;
        
        // end+1 추가
        mart[discount[end+1]] = mart[discount[end+1]] === undefined ? 1 : mart[discount[end+1]] + 1;
        
        start++;
        end++;
        
    }
    
    return result;
}

function isAllInclude(want, number, mart){
    let check = true;
    
    want.forEach((thing, idx) => {
        if((mart[thing]??0) < number[idx]) check = false;
    })
    
    return check;
}