function solution(diffs, times, limit) {
    let answer = binarySearch(diffs, times, limit);
    return answer;
}

// LOWER BOUND
function binarySearch(diffs, times, limit){
    let left = 1;
    let right = diffs.reduce((acc, cur) => Math.max(acc, cur) ,1);
    
    while(left < right){
        let mid = parseInt((left + right) / 2);
        
        let time = getTime(diffs, times, mid);
        
        if(time > limit){
            left = mid + 1;
        }else{
            right = mid;
        }
    }
    
    return left;
}

function getTime(diffs, times, level){
    let time = 0;
    
    diffs.forEach((diff, idx) => {
        let time_cur = times[idx];
        let time_prev = idx === 0 ? 0 : times[idx-1];
        
        if(diff <= level){
            time += time_cur;
        }else{
            time += (diff-level) * (time_cur + time_prev) + time_cur;
        }
    })
    
    return time;
}